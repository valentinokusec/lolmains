package com.lolmains.services;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lolmains.domains.Build;
import com.lolmains.domains.Guide;
import com.lolmains.domains.Notes;




@Service
public interface NotesService {
	public List<Notes> getAll();
	public Notes addNotes(Notes Notes);
	public Notes findNotes(int id);
	
} 
