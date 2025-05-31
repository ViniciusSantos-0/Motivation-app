package com.example.motivation.repository

import com.example.motivation.infra.MotivationConstants
import java.util.*


data class Phrase(val description: String, val category: Int)

fun Int.random(): Int {
    return Random().nextInt(this)
}

class Mock {

    private val ALL = MotivationConstants.PHRASEFILTER.ALL
    private val MORNING = MotivationConstants.PHRASEFILTER.MORNING
    private val HAPPY = MotivationConstants.PHRASEFILTER.HAPPY

    private val mListPhrase: List<Phrase> = listOf(
        Phrase("Not knowing it was impossible, he went there and did it.", HAPPY),

        Phrase("You are not defeated when you lose, you are defeated when you give up!", HAPPY),

        Phrase("When it's darkest, we see the most stars!", HAPPY),

        Phrase("Insanity is doing the same thing over and over and expecting different results.", HAPPY),

        Phrase("Don’t stop when you’re tired, stop when you’re done.", HAPPY),

        Phrase("What can you do now that has the biggest impact on your success?", HAPPY),

        Phrase("The best way to predict the future is to invent it.", MORNING),

        Phrase("You miss all the chances you don’t take.", MORNING),

        Phrase("Failure is the seasoning that gives success its flavor.", MORNING),

        Phrase("Until one is committed, there is hesitancy!", MORNING),

        Phrase("If you don’t know where you want to go, any road will take you there.", MORNING),

        Phrase("If you believe, it makes all the difference.", MORNING),

        Phrase("Risks must be taken, because the greatest danger is not risking anything!", MORNING)
    )

    fun getPhrase(categoryId: Int): String {

        val filtered = mListPhrase.filter { it.category == categoryId || categoryId == ALL }
        val rand = (filtered.size).random()

        return filtered[rand].description
    }
}