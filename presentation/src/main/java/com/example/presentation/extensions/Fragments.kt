package com.example.presentation.extensions

import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.presentation.ui.MainActivity
import com.example.domain.state.Result
import com.example.presentation.R
import com.example.presentation.alerts.MainAlert
import com.example.presentation.alerts.MainAlert.Companion.ERROR_MESSAGE


fun Fragment.showProgress() {
    (requireActivity() as MainActivity).showProgress()
}

fun Fragment.hideProgress() {
    (requireActivity() as MainActivity).hideProgress()
}

fun Fragment.shouldShowProgress(isLoading: Boolean) {
    (requireActivity() as MainActivity).shouldShowProgress(isLoading)
}


fun Fragment.changeToolbarTitle(title: String) {
    (requireActivity() as MainActivity).changeTitleToolbar(title)
}


fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}


fun Fragment.navigate(accion: NavDirections) {
    findNavController().navigate(accion)
}


fun Fragment.showErrorApi(shouldCloseTheViewOnApiError: Boolean = false) {
    val dialog = MainAlert(kindOfMessage = ERROR_MESSAGE,
        messageBody = getString(R.string.error_service),
        clickOnAccept = {
            if (shouldCloseTheViewOnApiError) {
                findNavController().popBackStack()
            }
        })
    activity?.let { dialog.show(it.supportFragmentManager, "alertMessage") }
}

fun Fragment.showErrorNetwork(shouldCloseTheViewOnApiError: Boolean = false) {
    val dialog = MainAlert(kindOfMessage = ERROR_MESSAGE,
        messageBody = getString(R.string.verifica_conexion),
        clickOnAccept = {
            if (shouldCloseTheViewOnApiError) {
                findNavController().popBackStack()
            }
        })
    activity?.let { dialog.show(it.supportFragmentManager, "alertMessage") }
}

fun Fragment.onBackPress(action: () -> Unit) {
    requireActivity().onBackPressedDispatcher.addCallback(
        viewLifecycleOwner,
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                action()
            }
        })
}

fun Fragment.onBackGesture(onBackAction: () -> Unit) {
    requireActivity().onBackPressedDispatcher
        .addCallback(this) {
            isEnabled = false
            onBackAction.invoke()
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
}