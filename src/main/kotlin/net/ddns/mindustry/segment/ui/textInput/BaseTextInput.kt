package net.ddns.mindustry.segment.ui.textInput

import mindustry.gen.Call
import mindustry.gen.Player
import mindustry.net.NetConnection
import net.ddns.mindustry.segment.ui.Child

/**
 * A base class for text inputs. This isn't recommended for usage unless necessary.
 */
class BaseTextInput(
    override val title: String,
    override val message: String,
    override val id: Int,
    override val callback: (player: Player, Child) -> Unit,

    var text: String?,

    private val charCount: Int = 1024,
    private val default: String = "",
    private val numeric: Boolean = false,
) : Child(title, message, id, callback) {

    @Suppress("Unused")
    override fun show() {
        Call.textInput(this.id, this.title, this.message, this.charCount, this.default, this.numeric)
    }

    override fun show(connection: NetConnection) {
        Call.textInput(connection, this.id, this.title, this.message, this.charCount, this.default, this.numeric)
    }
}