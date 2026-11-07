/*
 * The Compukters Developers
 * Copyright 2026 Vsevolod Petrov (lazyhat)
 * Licensed under the Apache License, Version 2.0.
 */

package createaddition.boiler

import ru.lazyhat.compukters.api.contracts.GuestDevice
import ru.lazyhat.compukters.api.contracts.GuestRead
import ru.lazyhat.compukters.api.contracts.GuestRecord

/** One atomic server-tick observation. Heat: 0=none, 1=smouldering, 2=fading, 3=heated, 4=seething. */
@GuestRecord
data class BurnerStatus(
    val fuelAmount: Int,
    val fuelCapacity: Int,
    val heat: Int,
    val burnTicks: Int,
)

/** A Crafts & Additions liquid Blaze Burner created by applying a straw. Read-only. */
@GuestDevice("createaddition:liquid_burner", bindings = "LiquidBurnerBindings")
interface LiquidBurner {
    /** Recoverable liquid is separate from fuel already converted into burning time. */
    @GuestRead(binding = "status")
    fun status(): BurnerStatus
}
