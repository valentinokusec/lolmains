package com.lolmains.facade;

import org.springframework.stereotype.Service;

import com.lolmains.domains.BestOf;
import com.lolmains.domains.Guide;
import com.lolmains.forms.CreateGuide;

@Service
public interface EditFacade {

	public Guide editGuide(CreateGuide CreateGuide);
	public BestOf editBestof(CreateGuide CreateGuide);
	
}
