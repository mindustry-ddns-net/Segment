package net.ddns.mindustry.segment.ui

import mindustry.gen.Call
import mindustry.gen.Player
import mindustry.net.NetConnection

abstract class Child (
    private val title: String,
    private val message: String,
    private val id: Int,
    open val callback: (player: Player, text: String?, args: Array<String>) -> Unit,
    val args: Array<String> = arrayOf(),
    private val default: String = "",
    ) {

    @Suppress("Unused")
    abstract fun show()

    abstract fun show(connection: NetConnection)
}