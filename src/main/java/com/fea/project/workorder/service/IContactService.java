package com.fea.project.workorder.service;

import com.fea.project.workorder.model.ContactModel;

public interface IContactService {

	Integer insert(ContactModel model);
	
	ContactModel selectByWorkorderId(Long workorderId);
}
