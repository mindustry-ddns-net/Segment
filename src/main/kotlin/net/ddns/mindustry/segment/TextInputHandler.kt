package net.ddns.mindustry.segment

import mindustry.gen.Player

/**
 * Class to handle text inputs. This shouldn't be initialized. Use `segment.textInputHandler` instead. Please.
 */
class TextInputHandler() {
    private var textInputs: MutableMap<Player, BaseTextInput> = mutableMapOf()

    /**
     * Adds a text input for a given player.
     */
    fun addTextInput(player: Player, title: String, message: String, callback: (player: Player, text: String?) -> Unit,
                     charCount: Int = 1024, default: String = "", numeric: Boolean = false): BaseTextInput {
        val id = generateID()
        val textInput = BaseTextInput(title, message, id, callback, charCount, default, numeric)  // this counts as
                                                                                                  // necessary usage.

        textInputs[player] = textInput
        return textInput
    }

    /**
     * Executes the callback.
     * @param player The player whose callback will be called.
     */
    fun executeCallback(player: Player, text: String?) {
        textInputs[player]!!.callback(player, text)
    }

    /**
     * Removes a text input.
     */
    fun removeTextInput(player: Player) {
        textInputs.remove(player)
    }

    /**
     * Generates an ID. Duplicate IDs aren't a design flaw but rather a stroke of horrific luck. Heck, you probably
     * deserved it!
     */
    private fun generateID(): Int {
        return (Int.MIN_VALUE..Int.MAX_VALUE).random() // pray
    }
}