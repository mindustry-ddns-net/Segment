package net.ddns.mindustry.segment.ui

import mindustry.gen.Player
import mindustry.net.NetConnection

abstract class Child (
    open val title: String,
    open val message: String,
    open val id: Int,
    open val callback: (player: Player, args: Array<String>, Child) -> Unit,
    val args: Array<String> = arrayOf(),
    private val default: String = "",
    ) {

    @Suppress("Unused")
    abstract fun show()

    abstract fun show(connection: NetConnection)
}