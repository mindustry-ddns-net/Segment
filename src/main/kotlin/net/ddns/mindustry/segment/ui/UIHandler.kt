package net.ddns.mindustry.segment.ui

import arc.Events
import mindustry.game.EventType
import mindustry.gen.Player

// NOTE: due to current Mindustry API limitations, events cannot be abstracted. Bummer.
abstract class UIHandler<T>
        where T : Child {
    abstract var children: MutableMap<Int, T>;
    private var index = 0;

//    init {
//        Events.on(EventType.TextInputEvent::class.java)
//    }

    fun executeCallback(id: Int, player: Player) {
        val args = children[id]!!.args
        children[id]!!.callback(player, args, children[id]!!)
    }

//    abstract fun executeCallback(id: Int, player: Player, text: String?)

    private fun removeChild(id: Int) {
        children.remove(id)
    }

    fun generateID(): Int {
        return index++
    }
}