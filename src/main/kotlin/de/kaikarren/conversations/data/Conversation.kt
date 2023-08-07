package de.kaikarren.conversations.data

import java.time.Instant
import java.util.*

/**
 * Class that represents a conversation between n participants.
 *
 * A conversation can be divided into a series of messages.
 */
data class Conversation(
    var id : String = UUID.randomUUID().toString(),
    val timestamp: String = Instant.now().toString(),
    var participants : MutableList<String> = mutableListOf(),
    val messages : MutableList<Message> = mutableListOf(),
    val slots: MutableList<Slot> = mutableListOf(),
    val labels: MutableList<Label> = mutableListOf(),
) {
    override fun toString(): String {
        return "Conversation (participants.size:${participants.size}, messages.size:${messages.size})"
    }

    fun addMessage(message: Message) {

        messages.add(message)

        if(!participants.contains(message.participant)){
            participants.add(message.participant)
        }

    }
}