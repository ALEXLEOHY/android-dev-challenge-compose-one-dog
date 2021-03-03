package com.example.androiddevchallenge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.Dragon

/**
 * MainViewModel is the bridge to communicate between data layer and ui layer.
 *
 * @author Yang Han
 * @since 2021/3/3
 */

class MainViewmodel : ViewModel() {

    /**
     * The LiveData variable to observe Contact object list.
     */
    val dogsLiveData: LiveData<List<Dragon>>
        get() = _dogsLiveData

    private val _dogsLiveData = MutableLiveData<List<Dragon>>()

    private val dogs =
        mutableListOf(
            Dragon(
                dragonName = "Pterosauria",
                dragonDescribe = "  Pterosaurs, also known as Pterosauria, are flying reptiles. Commonly known as flying dragon. The largest pterosaurs can reach 6 to 8 m when their wings are spread.",
                catch = false,
                dragonImageId = R.drawable.pterodactyl
            ),
            Dragon(
                dragonName = "Velociraptor",
                dragonDescribe = "  Velociraptor, also translated as Velociraptor, Velociraptor, means \"swift thief\" in Latin. It is a kind of lizard and theropod dinosaur, which lived about 83 to 70 million years ago in late chalk. discipline.",
                catch = false,
                dragonImageId = R.drawable.raptor
            ),
            Dragon(
                dragonName = "Stegosaurus",
                dragonDescribe = "  Stegosaurus is a huge herbivorous dinosaur. It is a herbivorous animal that lived in the late Jurassic. It has a row of huge bony plates on its back and a dangerous tail with four spikes to defend it. The attack of predators is about 7-9 meters long, 2.35 meters to 3.5 meters high, and 2 to 4 tons in weight.",
                catch = false,
                dragonImageId = R.drawable.stegosaurus
            ),
            Dragon(
                dragonName = "Triceratops",
                dragonDescribe = "  Triceratops (genus name: Triceratops) Ornithischia is a genus of herbivorous dinosaurs of the suborder Ceratosaurus family.",
                catch = false,
                dragonImageId = R.drawable.triceratops
            ),
            Dragon(
                dragonName = "Tyrannosaurus",
                dragonDescribe = "  Tyrannosaurus Rex (Tyrannosaurus Rex) [1], lived in the Maastricht period (MAA) at the end of the Cretaceous period, about 68.5 million to 65 million years ago, the last period of the Cretaceous, it is the Cretaceous One of the last non-avian dinosaurs before the tertiary extinction event.",
                catch = false,
                dragonImageId = R.drawable.tyrannosaurus
            ),
            Dragon(
                dragonName = "Diplodocus",
                dragonDescribe = "  Diplodocus (scientific name: Diplodocus) is a genus of dinosaurs in the Diplodocidae family. Diplodocus lived in western North America at the end of the Jurassic.",
                catch = false,
                dragonImageId = R.drawable.diplodocus
            ),
            Dragon(
                dragonName = "Parasaurolophus",
                dragonDescribe = "  Parasaurolophus, also known as Parasaurolophus, Parasaurolophus, Parasaurolophus One genus, which lived in North America in the Late Cretaceous Period, about 76 to 73 million years ago.",
                catch = false,
                dragonImageId = R.drawable.parasaurolophus
            ),
        )

    fun pullData() {
        _dogsLiveData.value = dogs
    }
}