package com.raininman.monito.petItem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/petItem")
public class PetItemController {

    private final PetItemService petItemService;

    @Autowired
    public PetItemController(PetItemService petItemService) {
        this.petItemService = petItemService;
    }

    @GetMapping
    public List<PetItem> getPetItems() {
        return petItemService.getPetItems();
    }

    @PostMapping
    public void postPetItem(@RequestBody PetItem petItem) {
        petItemService.addNewPetItem(petItem);
    }

    @DeleteMapping(path = "{petItemId}")
    public void deletePetItem(@PathVariable("petItemId") Long id) {
        petItemService.deletePetItem(id);
    }

    @PutMapping(path = "{petItemId}")
    public void updatePetItem(
            @PathVariable("petItemId") Long id,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) String age,
            @RequestParam(required = false) String price,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String size,
            @RequestParam(required = false) boolean vaccinated,
            @RequestParam(required = false) boolean dewormed,
            @RequestParam(required = false) boolean cert,
            @RequestParam(required = false) boolean microchip,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) LocalDate publishDate,
            @RequestParam(required = false) String additionalInformation,
            @RequestParam(required = false) List<String> imgs
    ) {
        petItemService.updatePetItem(id, title, description,age, price, gender, color, size, vaccinated, dewormed, cert, microchip, location, publishDate, additionalInformation, imgs);
    }
}
