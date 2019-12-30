package guru.springframework.sfgpetclinic.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetTypeService;
import guru.springframework.sfgpetclinic.service.SpecialtiesService;
import guru.springframework.sfgpetclinic.service.VetService;
import guru.springframework.sfgpetclinic.service.VisitService;


@Component
public class DataLoader implements CommandLineRunner{

	
	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtiesService specialtiesService;
	private final VisitService visitService;
	
	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService, VisitService visitService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtiesService = specialtiesService;
		this.visitService = visitService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		int count = petTypeService.findAll().size();
		
		if(count == 0) {
			loadData();
		}
	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType savedDogType = petTypeService.save(dog);
		
		PetType cat = new PetType();
		cat.setName("Cat");
		PetType savedCatType = petTypeService.save(cat);
		
		Speciality radiology = new Speciality();
		radiology.setDescription("Radiology");
		Speciality savedRadiology = specialtiesService.save(radiology);
		
		Speciality surgery = new Speciality();
		surgery.setDescription("Surgery");
		Speciality savedSurgery = specialtiesService.save(surgery);
		
		Speciality dentistry = new Speciality();
		dentistry.setDescription("Dentistry");
		Speciality savedDentistry = specialtiesService.save(dentistry);
		
		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("infantry road");
		owner1.setCity("Bangalore");
		owner1.setTelephone("9876456789");
		
		Pet mikesPet = new Pet();
		mikesPet.setPetType(savedDogType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
		owner1.getPets().add(mikesPet);
		
		ownerService.save(owner1);
		
		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("m g road");
		owner2.setCity("chennai");
		owner2.setTelephone("8767345678");
		
		Pet fianosCat = new Pet();
		fianosCat.setPetType(savedCatType);
		fianosCat.setOwner(owner2);
		fianosCat.setBirthDate(LocalDate.now());
		fianosCat.setName("Just Cat");
		owner2.getPets().add(fianosCat);
		
		ownerService.save(owner2);
		
		Visit catVisit = new Visit();
		catVisit.setPet(fianosCat);
		catVisit.setDate(LocalDate.now());
		catVisit.setDescription("Sneezy Kitty");
		
		visitService.save(catVisit);
		
		System.out.println("Loaded Owners.....");
		
		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialities().add(savedRadiology);
		
		vetService.save(vet1);
		
		Vet vet2 = new Vet();
		vet2.setFirstName("jimmy");
		vet2.setLastName("folkan");
		vet2.getSpecialities().add(savedSurgery);
		
		vetService.save(vet2);
		
		System.out.println("Loaded Vets.....");
	}
	
	

}
