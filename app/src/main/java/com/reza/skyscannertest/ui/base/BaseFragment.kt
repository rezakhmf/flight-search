package com.reza.skyscannertest.ui.base

import android.content.Context
import android.os.Bundle
import android.support.annotation.StringRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseFragment: DaggerFragment() {

    private var mActivity: BaseActivity? = null
    private var mRootView: View? = null

    abstract fun layoutId(): Int


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is BaseActivity) {
            this.mActivity = context
            mActivity?.onFragmentAttached()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(layoutId(), container, false)

    open fun onBackPressed() {}

    override fun onDetach() {
        mActivity = null
        super.onDetach()
    }

    fun getBaseActivity(): BaseActivity? {
        return mActivity
    }

    fun isNetworkConnected(): Boolean {
        return mActivity != null && mActivity!!.isNetworkConnected()
    }

    internal fun showProgress() = progressStatus(View.VISIBLE)

    internal fun hideProgress() = progressStatus(View.GONE)

    private fun progressStatus(viewStatus: Int) =
        with(activity) { if (this is BaseActivity) this.progress.visibility = viewStatus }


    internal fun firstTimeCreated(savedInstanceState: Bundle?) = savedInstanceState == null

    internal fun notify(@StringRes message: String) =
        Toast.makeText(activity,message, Toast.LENGTH_SHORT).show()
    
    public interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }

}