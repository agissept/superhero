package com.example.superhero

import androidx.core.app.GrammaticalInflectionManagerCompat.GrammaticalGender
import com.google.gson.annotations.SerializedName

//create dataclass form
//{
//    response: "success",
//    id: "201",
//    name: "Daredevil",
//    powerstats: {
//    intelligence: "75",
//    strength: "13",
//    speed: "25",
//    durability: "35",
//    power: "61",
//    combat: "100"
//},
//    biography: {
//    full-name: "Matt Murdock",
//    alter-egos: "No alter egos found.",
//    aliases: [
//    "Matt",
//    "Jack Batlin",
//    "Kingpin of Crime",
//    "Laurent LeVasseur",
//    "Michael "Mike" Murdock",
//    "Scarlet Swashbuckler",
//    "Nameless One",
//    "Kingpin of Hell's Kitchen",
//    "The Man Without Fear",
//    "The Guardian Devil",
//    "DD",
//    "Red",
//    "Hornhead",
//    "Cooper Peyton",
//    "Captain Universe"
//    ],
//    place-of-birth: "New York City, New York",
//    first-appearance: "Daredevil #1 (April, 1964)",
//    publisher: "Marvel Comics",
//    alignment: "good"
//},
//    appearance: {
//    gender: "Male",
//    race: "Human",
//    height: [
//    "6'0",
//    "183 cm"
//    ],
//    weight: [
//    "200 lb",
//    "90 kg"
//    ],
//    eye-color: "Blue",
//    hair-color: "Red"
//},
//    work: {
//    occupation: "Adventurer, vigilante, Attorney at Law",
//    base: "Hell's Kitchen, New York, New York, Shadowland (formerly)"
//},
//    connections: {
//    group-affiliation: "none; Formerly: partner of Black Widow (Natasha Romanoff), Defenders, S.H.I.E.L.D., Marvel Knights, Secret Avengers (Civil War), Hand leader.",
//    relatives: "Jonathan "Battling Jack" Murdock (Father, deceased), Maggie Murdock (aka Sister Maggie, Mother), Milla Donovan (ex-wife)"
//},
//    image: {
//    url: "https://www.superherodb.com/pictures2/portraits/10/100/52.jpg"
//}
//}

data class SuperHero(
    val response: String,
    val id: String,
    val name: String,
    val powerstats: Powerstats,
    val biography: Biography,
    val appearance: Appearance,
    val image: Image
)

data class Powerstats(
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)

data class Biography(
    @SerializedName("full-name")
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    @SerializedName("place-of-birth")
    val placeOfBirth: String,
    @SerializedName("first-appearance")
    val firstAppearance: String,
    val publisher: String,
    val alignment: String
)

data class Appearance(
    val gender: String,
    val race: String
)

data class Image(
    val url: String
)