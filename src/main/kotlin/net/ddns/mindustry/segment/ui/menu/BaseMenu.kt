package net.ddns.mindustry.segment.ui.menu

import arc.util.Log
import mindustry.gen.Call
import mindustry.gen.Player
import mindustry.net.NetConnection
import net.ddns.mindustry.segment.ui.Child

class BaseMenu(
    title: String,
    message: String,
    id: Int,
    private var options: Array<Array<String>>,
    var option: Int,
    callback: (Player, Child) -> Unit
) : Child(title, message, id, callback) {
    override fun show() {
        Call.menu(this.id, this.title, this.message, this.options)
    }

    override fun show(connection: NetConnection) {
        Call.menu(connection, this.id, this.title, this.message, this.options)
    }

    fun showFollowup() {
        Call.followUpMenu(this.id, this.title, this.message, this.options)
    }

    fun showFollowup(connection: NetConnection) {
        Call.followUpMenu(this.id, this.title, this.message, this.options)
    }
}