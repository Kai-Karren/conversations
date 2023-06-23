package de.kaikarren.conversations.data

import com.google.gson.annotations.SerializedName
import java.time.Instant
import java.util.*

/**
 * Data class that represents a Conversation Message.
 *
 * Usually a message contains text of a certain participant and optionally different information
 * like classified intents and so on.
 *
 * Intents are a list to support multi-intent use cases. However, outside of research systems, you
 * will usually find only one intent assigned to an utterance.
 *
 *
 * It also contains a MutableList of labels.
 *
 *          {
 *              "participant": "user",
 *              "text": "Hello, I am calling to make a reservation.",
 *              "intents": [
 *                  "intent": {
 *                      "name": "reservation",
 *                      "confidence": 1.0
 *                  }
 *              ],
 *              "intent_ranking": [
 *                  {
 *                      "name": "reservation",
 *                      "confidence": 1.0
 *                  }
 *              ],
 *              "slots": [],
 *              "labels": [
 *                  "greeting", "reservation_request"
 *              ],
 *          }
 *
 * Please note to prevent GSON from loading null for the labels when they are not given,
 * all fields need default values. See https://proandroiddev.com/safe-parsing-kotlin-data-classes-with-gson-4d560fe3cdd2
 */
data class Message(
    val id : String = UUID.randomUUID().toString(),
    val participant : String = "",
    val text: String = "",
    val timestamp: String = Instant.now().toString(),
    val intents: MutableList<Intent> = mutableListOf(),

    @SerializedName("intent_ranking")
    val intentRanking: MutableList<Intent> = mutableListOf(),

    val entities: MutableList<Entity> = mutableListOf(),
    val slots: MutableList<Slot> = mutableListOf(),
    var labels: MutableList<Label> = mutableListOf(),
)