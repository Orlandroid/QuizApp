package com.example.presentation.providers

import com.example.domain.entities.local.Answer
import com.example.domain.entities.local.Question
import com.example.presentation.R

class QuestionsProvider {

    private val questionOne =
        Question(
            backgroundQuestions = R.drawable.never_wok_on_fryday,
            question = "¿Que dia de la semala hal no ha trabajado en años?",
            correctAnswerId = 4,
            answers = answersQuestionOne()
        )


    private fun answersQuestionOne() = listOf(
        Answer(1, "Lunes"), Answer(2, "Martes"), Answer(3, "Jueves"), Answer(4, "Viernes")
    )


    private val questionTwo =
        Question(
            backgroundQuestions = R.drawable.malcom_portada,
            question = "¿Que le enseña reese secretamente a lois?",
            correctAnswerId = 3,
            answers = answersQuestionTwo()
        )


    private fun answersQuestionTwo() = listOf(
        Answer(1, "¿Como cocinar?"),
        Answer(2, "¿Como tocar el piano?"),
        Answer(3, "¿Como andar en bici?"),
        Answer(4, "¿Como usar el dvd?")
    )

    private val questionThree =
        Question(
            backgroundQuestions = R.drawable.broken_leg,
            question = "¿Como pierde la pierna la abuela?",
            correctAnswerId = 2,
            answers = answersQuestionThree()
        )


    private fun answersQuestionThree() = listOf(
        Answer(1, "¿Tratando de conseguir un dulce de una piñata?"),
        Answer(2, "¿Salvando a dewey de ser atropellado?"),
        Answer(3, "¿Mordida de un perro?"),
        Answer(4, "¿Jugando baskquetball con reese?")
    )

    private val questionFour =
        Question(
            backgroundQuestions = R.drawable.first_girlfriend,
            question = "¿Cual es el nombre de la primera novia de malcom?",
            correctAnswerId = 4,
            answers = answersQuestionFour()
        )


    private fun answersQuestionFour() = listOf(
        Answer(1, "Diana"),
        Answer(2, "Cyntia"),
        Answer(3, "Alison"),
        Answer(4, "Sarah")
    )

    private val questionFive =
        Question(
            backgroundQuestions = R.drawable.malcom_portada,
            question = "¿Cual es el nombre de la esposa de francis?",
            correctAnswerId = 1,
            answers = answersQuestionFive()
        )


    private fun answersQuestionFive() = listOf(
        Answer(1, "Piama"),
        Answer(2, "Marita"),
        Answer(3, "Franchesta"),
        Answer(4, "Audrey")
    )

    private val questionSix =
        Question(
            backgroundQuestions = R.drawable.malcom_portada,
            question = "¿Cual es el IQ del malcom?",
            correctAnswerId = 2,
            answers = answersQuestionSix()
        )


    private fun answersQuestionSix() = listOf(
        Answer(1, "140"),
        Answer(2, "165"),
        Answer(3, "150"),
        Answer(4, "180")
    )

    private val questionSeven =
        Question(
            backgroundQuestions = R.drawable.malcom_portada,
            question = "¿Que hijo nacio segundo?",
            correctAnswerId = 3,
            answers = answersQuestionSeven()
        )


    private fun answersQuestionSeven() = listOf(
        Answer(1, "Malcom"),
        Answer(2, "Francis"),
        Answer(3, "Reese"),
        Answer(4, "Dewey")
    )

    private val questionEight =
        Question(
            backgroundQuestions = R.drawable.malcom_portada,
            question = "¿Cuantas temporadas tiene malcom in the middle?",
            correctAnswerId = 1,
            answers = answersQuestionEight()
        )


    private fun answersQuestionEight() = listOf(
        Answer(1, "7"),
        Answer(2, "6"),
        Answer(3, "8"),
        Answer(4, "5")
    )

    private val questionNine =
        Question(
            backgroundQuestions = R.drawable.malcom_portada,
            question = "¿Que amigo de malcom usa silla de ruedas?",
            correctAnswerId = 1,
            answers = answersQuestionNine()
        )


    private fun answersQuestionNine() = listOf(
        Answer(1, "Stevie"),
        Answer(2, "Manny"),
        Answer(3, "Thomas"),
        Answer(4, "Oliver")
    )

    private val questionTeen =
        Question(
            backgroundQuestions = R.drawable.sombrero_magico,
            question = "Qué es lo que consigue Francis después de la huelga de hambre en la escuela militar.",
            correctAnswerId = 1,
            answers = answersQuestionTeen()
        )


    private fun answersQuestionTeen() = listOf(
        Answer(1, "Un sombrero mágico"),
        Answer(2, "Comida para todos"),
        Answer(3, "100 quacks ")
    )

    private val questionEleven =
        Question(
            backgroundQuestions = R.drawable.imagination_mujeres,
            question = "¿Cuando lios imagina sus hijos como mujeres cuales son sus nombres?",
            correctAnswerId = 1,
            answers = answersQuestionEleven()
        )


    private fun answersQuestionEleven() = listOf(
        Answer(1, "Mallory,Renee and Daisy"),
        Answer(2, "Mildred,Rose and Dian"),
        Answer(3, "Martha,Rachel and Danielle"),
        Answer(4, "Marharet,Receba and Denise")
    )

    private val questionTwelwe =
        Question(
            backgroundQuestions = R.drawable.shirt_luck,
            question = "¿De que color es la camiseta de la suerte de dewey?",
            correctAnswerId = 1,
            answers = answersQuestionTwelwe()
        )


    private fun answersQuestionTwelwe() = listOf(
        Answer(1, "Red"),
        Answer(2, "Blue"),
        Answer(3, "Yellow"),
        Answer(4, "Black")
    )

    private val questionTrece =
        Question(
            backgroundQuestions = R.drawable.dewey_dog,
            question = "El nombre que le pone Dewey al perro que rescata y luego usa para obligar a sus hermanos a obedecerlo.",
            correctAnswerId = 3,
            answers = answersQuestionTrece()
        )


    private fun answersQuestionTrece() = listOf(
        Answer(1, "Pelusa"),
        Answer(2, "Bernado"),
        Answer(3, "Caramelo"),
        Answer(4, "Fufy")
    )

    private val questionFourteen =
        Question(
            backgroundQuestions = R.drawable.malcom_portada,
            question = "¿Cómo muere el personaje de Malcolm en el juego que juega en la computadora que Hall le compra al vecino?",
            correctAnswerId = 4,
            answers = answersQuestionFourteen()
        )


    private fun answersQuestionFourteen() = listOf(
        Answer(1, "Se ahoga de borracho"),
        Answer(2, "Se atora debajo de la mesa cuando busca una hambuergesa que se le cayo"),
        Answer(3, "Le da un infarto porque es muy gordo"),
        Answer(4, "Se apuñala a si mismo despues de hacerce un sandwich")
    )

    private val questionFiveTeen =
        Question(
            backgroundQuestions = R.drawable.cindy,
            question = "El nombre de la puerquita que usan para molestar a Reese e invitarlo a una cita.",
            correctAnswerId = 4,
            answers = answersQuestionFiveTeen()
        )


    private fun answersQuestionFiveTeen() = listOf(
        Answer(1, "Karen"),
        Answer(2, "Sahara"),
        Answer(3, "Leila"),
        Answer(4, "Cindy")
    )

    private val questionSixTeen =
        Question(
            backgroundQuestions = R.drawable.mono,
            question = "¿Qué animal intenta matar a Craig cuando tiene los brazos y piernas fracturados?",
            correctAnswerId = 2,
            answers = answersQuestionSixTeen()
        )


    private fun answersQuestionSixTeen() = listOf(
        Answer(1, "Un ardilla rabiosa."),
        Answer(2, "Un mono capuchino con un pañal."),
        Answer(3, "Un perro")
    )


    private val questionSevenTeen =
        Question(
            backgroundQuestions = R.drawable.komodo_300,
            question = "El nombre del fuego pirotécnico que dejó ciegos a Malcolm, Reese y Francis.",
            correctAnswerId = 1,
            answers = answersQuestionSevenTeen()
        )


    private fun answersQuestionSevenTeen() = listOf(
        Answer(1, "Komodo 300"),
        Answer(2, "La piedra del diablo"),
        Answer(3, "Hipersonico 300")
    )

    private val questionEithTeen =
        Question(
            backgroundQuestions = R.drawable.papa_lios,
            question = "¿Por qué a Dewey le da miedo su abuelo, el papá de lois?",
            correctAnswerId = 4,
            answers = answersQuestionEithTeen()
        )


    private fun answersQuestionEithTeen() = listOf(
        Answer(1, "Porque un día explotó una granada en el refrigerador"),
        Answer(2, "Porque maltrata a lois"),
        Answer(3, "Porque tenía otra familia en Canadá"),
        Answer(4, "Porque atropelló su triciclo con su carro")
    )

    private val questionNineTeen =
        Question(
            backgroundQuestions = R.drawable.krelboynes,
            question = "¿Cómo le dicen al grupo de amigos de Malcolm en la escuela?",
            correctAnswerId = 1,
            answers = answersQuestionNineTeen()
        )


    private fun answersQuestionNineTeen() = listOf(
        Answer(1, "Krelboynes"),
        Answer(2, "Los nerds"),
        Answer(3, "Cerebritos"),
        Answer(4, "Los especiales"),
    )

    fun getTeenRandomsQuestions(questionsToShow: Int = 10) =
        getAllTheQuestions().shuffled().take(questionsToShow)


    private fun getAllTheQuestions() = listOf(
        questionOne,
        questionTwo,
        questionThree,
        questionFour,
        questionFive,
        questionSix,
        questionSeven,
        questionEight,
        questionNine,
        questionTeen,
        questionEleven,
        questionTwelwe,
        questionTrece,
        questionFourteen,
        questionFiveTeen,
        questionSixTeen,
        questionSevenTeen,
        questionEithTeen,
        questionNineTeen
    )

}