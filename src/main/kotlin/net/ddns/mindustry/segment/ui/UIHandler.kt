package net.ddns.mindustry.segment.ui

import mindustry.gen.Player

abstract class UIHandler<T>
        where T : Child {
    abstract var children: MutableMap<Int, T>;
    private var index = 0;

    fun executeCallback(id: Int, player: Player, text: String?) {
        val args = children[id]!!.args
        children[id]!!.callback(player, text, args)
    }

//    abstract fun executeCallback(id: Int, player: Player, text: String?)

    private fun removeChild(id: Int) {
        children.remove(id)
    }

    fun generateID(): Int {
        return index++
    }
}