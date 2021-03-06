package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.Dao;
import com.mycompany.myapp.dto.Music;

@Component
public class ServiceImpl implements Service {
	@Autowired
	private Dao dao;
	
	@Override
	public void musicUpload(Music music) {
		dao.musicInsert(music);
	}

	@Override
	public List<Music> getList() {
		return dao.getList();
	}
}
