package com.example.cupcake.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class OrderViewModelTest {

    /*
    We use LiveData to update our UI as soon as a value changes. Our UI runs on what we call the "main thread."
    Unless otherwise specified, a unit test assumes that everything runs on the main thread.
    However, because LiveData objects cannot access the main thread we have to explicitly state that LiveData objects should not call the main thread.
     */
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    /*
    When testing the values of a LiveData object, the objects need to be observed in order for changes to be emitted
     */
    @Test
    fun quantity_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.quantity.observeForever {  }
        viewModel.setQuantity(12)
        assertEquals(12, viewModel.quantity.value)
    }

    @Test
    fun price_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.price.observeForever {  }
        viewModel.setQuantity(12)
        assertEquals("$27.00", viewModel.price.value)
    }
}