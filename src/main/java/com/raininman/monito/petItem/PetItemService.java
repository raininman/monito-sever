package com.raininman.monito.petItem;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PetItemService {

    private final PetItemRepository petItemRepository;

    @Autowired
    public PetItemService(PetItemRepository petItemRepository) {
        this.petItemRepository = petItemRepository;
    }

    public List<PetItem> getPetItems() {
        return petItemRepository.findAll();
    }

    public void addNewPetItem(PetItem petItem) {
        Optional<PetItem> petItemByTitle = petItemRepository.findPetItemByTitle(petItem.getTitle());
        if (petItemByTitle.isPresent()) {
            throw new IllegalStateException("Title taken");
        }
        petItemRepository.save(petItem);
    }

    public void deletePetItem(Long id) {
        boolean exists = petItemRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Id " + id + " not found");

        }
        petItemRepository.deleteById(id);
    }

    @Transactional
    public void updatePetItem(Long id, String title, String description,String age, String price, String gender, String color, String size, boolean vaccinated, boolean dewormed, boolean cert, boolean microchip, String location, LocalDate publishDate, String additionalInformation, List<String> imgs) {
        PetItem petItem = petItemRepository.findById(id).orElseThrow(() -> new IllegalStateException("Id " + id + " not found"));
        if (title != null && title.length() > 0) {
            petItem.setTitle(title);
        }
        if (description != null && description.length() > 0) {
            petItem.setDescription(description);
        }
        if (age != null && age.length() > 0) {
            petItem.setAge(age);
        }
        if (price != null && price.length() > 0) {
            petItem.setPrice(price);
        }
        if (gender != null && gender.length() > 0) {
            petItem.setGender(gender);
        }
        if (color != null && color.length() > 0) {
            petItem.setColor(color);
        }
        if (size != null && size.length() > 0) {
            petItem.setSize(size);
        }

        petItem.setVaccinated(vaccinated);

        petItem.setDewormed(dewormed);

        petItem.setCert(cert);

        petItem.setMicrochip(microchip);


        if (location != null && location.length() > 0) {
            petItem.setLocation(location);
        }

        petItem.setPublishDate(publishDate);
        if (imgs != null && imgs.size() > 0) {
            petItem.setImgs(imgs);
        }


    }
}
