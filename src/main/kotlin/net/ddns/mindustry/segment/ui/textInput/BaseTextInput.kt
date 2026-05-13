package net.ddns.mindustry.segment.ui.textInput

import mindustry.gen.Call
import mindustry.gen.Player
import mindustry.net.NetConnection

/**
 * A base class for text inputs. This isn't recommended for usage unless necessary.
 */
class BaseTextInput(
    val title: String, val message: String, val id: Int,
    val callback: (player: Player, text: String?, args: Array<String>) -> Unit, val charCount: Int = 1024,
    val default: String = "", val numeric: Boolean = false, val args: Array<String> = arrayOf()) {

    @Suppress("Unused")
    fun show() {
        Call.textInput(this.id, this.title, this.message, this.charCount, this.default, this.numeric)
    }

    fun show(connection: NetConnection) {
        Call.textInput(connection, this.id, this.title, this.message, this.charCount, this.default, this.numeric)
    }
}