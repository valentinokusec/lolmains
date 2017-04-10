package com.lolmains.facade;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lolmains.domains.BestOf;
import com.lolmains.domains.Discussion;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Knowledge;
import com.lolmains.domains.Mains;
import com.lolmains.domains.User;
import com.lolmains.forms.CreateGuide;
import com.lolmains.forms.CreateKnowledge;
import com.lolmains.forms.CreateMain;
import com.lolmains.forms.CreateMember;
import com.lolmains.forms.CreateTopic;
import com.lolmains.forms.CreateUser;

@Service
public interface CreateFacade {
	public Mains createMain(CreateMain CreateMain);
	public Guide createPlaystyle(CreateGuide CreateGuide);
	public BestOf createBestOf(CreateGuide CreateGuide);
	public Discussion createDiscussion(CreateTopic CreateTopic);
	public User createUser(CreateUser CreateUser);
	public Mains createMember(CreateMember CreateMember);
	public Knowledge createKnowledge(CreateKnowledge CreateKnowledge);

}
