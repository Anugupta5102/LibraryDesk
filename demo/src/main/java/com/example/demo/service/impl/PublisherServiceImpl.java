package com.example.demo.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Publisher;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.PublisherRepository;
import com.example.demo.service.PublisherService;

@Service
public class PublisherServiceImpl implements PublisherService {

	private final PublisherRepository publisherRepository;

	public PublisherServiceImpl(PublisherRepository publisherRepository) {
		this.publisherRepository = publisherRepository;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Publisher> findAllPublishers() {
		return publisherRepository.findAll();
	}

	@Override
	public Publisher findPublisherById(Long id) {
		return publisherRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Publisher not found  with ID %d", id)));
	}

	@Override
	public void createPublisher(Publisher publisher) {
		publisherRepository.save(publisher);
	}

	@Override
	public void updatePublisher(Publisher publisher) {
		publisherRepository.save(publisher);
	}

	@Override
	public void deletePublisher(Long id) {
		var publisher = publisherRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Publisher not found  with ID %d", id)));

		publisherRepository.deleteById(publisher.getId());
	}

}