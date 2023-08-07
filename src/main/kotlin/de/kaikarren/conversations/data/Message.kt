package de.kaikarren.conversations.data

import com.google.gson.annotations.SerializedName
import java.time.Instant
import java.util.*

/**
 * Data class that represents a message in a conversation.
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
 * {
 *   "id": "1e84c925-09f5-41aa-a419-199ce06e0567",
 *   "participant": "John Doe",
 *   "text": "I would like to make a reservation.",
 *   "timestamp": "2023-08-07T12:51:44.582190600Z",
 *   "intents": [
 *     {
 *       "name": "reservation_request",
 *       "confidence": 0.81,
 *       "classifier": "unit_test"
 *     }
 *   ],
 *   "intent_ranking": [
 *     {
 *       "name": "reservation_request",
 *       "confidence": 0.81,
 *       "classifier": "unit_test"
 *     }
 *   ],
 *   "entities": [],
 *   "slots": [],
 *   "labels": []
 * }
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