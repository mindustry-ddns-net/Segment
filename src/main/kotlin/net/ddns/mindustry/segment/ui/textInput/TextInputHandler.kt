package net.ddns.mindustry.segment.ui.textInput

import arc.Events
import mindustry.game.EventType
import mindustry.gen.Player
import net.ddns.mindustry.segment.ui.UIHandler

/**
 * Class to handle text inputs.
 */
class TextInputHandler : UIHandler<BaseTextInput>() {
    override var children: MutableMap<Int, BaseTextInput> = mutableMapOf()

    init {
        Events.on(EventType.TextInputEvent::class.java, ::textInputEvent)
    }

    /**
     * Adds a text input for a given player.
     */
    fun addTextInput(title: String, message: String, callback: (player: Player, text: String?, args: Array<String>) -> Unit,
                     charCount: Int = 1024, default: String = "", numeric: Boolean = false
    ): BaseTextInput {
        val id = generateID()
        val textInput = BaseTextInput(title, message, id, callback, charCount, default, numeric)

        children[id] = textInput
        return textInput
    }

//    /**
//     * Executes the callback.
//     * @param player The player whose callback will be called.
//     */
//    private fun executeCallback(id: Int, player: Player, text: String?) {
//        val args = children[id]!!.args
//        children[id]!!.callback(player, text, args)
//    }

    /**
     * Removes a text input.
     */
    private fun removeTextInput(id: Int) {
        children.remove(id)
    }

//    /**
//     * Generates an ID. Duplicate IDs aren't a design flaw but rather a stroke of horrific luck. Heck, you probably
//     * deserved it!
//     */
//     private fun generateID(): Int {
//        return (Int.MIN_VALUE..Int.MAX_VALUE).random() // pray
//     }

    private fun textInputEvent(event: EventType.TextInputEvent) {
        this.executeCallback(event.textInputId, event.player, event.text)
        this.removeTextInput(event.textInputId)
    }
}