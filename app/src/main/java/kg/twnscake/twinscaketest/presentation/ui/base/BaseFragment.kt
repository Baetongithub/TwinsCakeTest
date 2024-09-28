package kg.twnscake.twinscaketest.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding>(
    private val viewBinding: (LayoutInflater, ViewGroup?, Boolean) -> VB
) : Fragment() {

    private var _vb: VB? = null
    val vb get() = _vb!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        _vb = viewBinding.invoke(inflater, container, false)

        initView()
        initData()
        checkInternet()
        return vb.root
    }

    abstract fun initView()
    protected open fun initData(){}
    protected open fun checkInternet(){}

    override fun onDestroyView() {
        super.onDestroyView()
        _vb = null
    }
}