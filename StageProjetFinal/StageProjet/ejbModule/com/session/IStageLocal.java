package com.session;

import java.util.List;

import javax.ejb.Local;

import com.entities.Stage;



@Local
public interface IStageLocal {

	public void AddStage(Stage s);
	public void DeleteStage(int code);
	public Stage getStage(int code);
	public List<Stage> getAllStages();
	public void UpdateStage(Stage s);
	public Long countNbStages();
	public Long countNbStagesByDepartement(String nomDepartement);
	public Long countNbStagesAffectes(String nomDepartement);
	public Long countNbStagesNonAffectes(String nomDepartement);
	public List<Stage> getStageBySujet(String sujet);
}
