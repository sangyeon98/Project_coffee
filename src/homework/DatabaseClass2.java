package homework;

import java.util.ArrayList;
import java.util.List;

public class DatabaseClass2 {
	public List<Coffee> coffeeList;
	public List<Tea> teaList;
	public List<Blended> blendedList;
	public List<Otherthings> otherthingsList;

	public DatabaseClass2() {
		coffeeList = new ArrayList<Coffee>();
		teaList = new ArrayList<Tea>();
		blendedList = new ArrayList<Blended>();
		otherthingsList = new ArrayList<Otherthings>();
	}

	public List<Coffee> getCoffeeList() {
		return coffeeList;
	}

	public void setCoffeeList(List<Coffee> coffeeList) {
		this.coffeeList = coffeeList;
	}

	public List<Tea> getTeaList() {
		return teaList;
	}

	public void setTeaList(List<Tea> teaList) {
		this.teaList = teaList;
	}

	public List<Blended> getBlendedList() {
		return blendedList;
	}

	public void setBlendedList(List<Blended> blendedList) {
		this.blendedList = blendedList;
	}

	public List<Otherthings> getOtherthingsList() {
		return otherthingsList;
	}

	public void setOtherthingsList(List<Otherthings> otherthingsList) {
		this.otherthingsList = otherthingsList;
	}

	// 커피 메뉴 추가 메소드
	public void addCoffee(Coffee coffee) {
		this.coffeeList.add(coffee);
	}

	// 티 메뉴 추가 메소드
	public void addTea(Tea tea) {
		this.teaList.add(tea);
	}

	// 블렌디드 메뉴 추가 메소드
	public void addBlended(Blended blended) {
		this.blendedList.add(blended);
	}

	// 나머지 메뉴 추가 메소드
	public void addOtherthings(Otherthings otherthings) {
		this.otherthingsList.add(otherthings);
	}

	// 현재 등록된 커피 메뉴 수[커피 list를 보여줄 2차원 배열의 크기에 사용]
	public int getCoffeeCount() {
		return coffeeList.size();
	}

	public int getTeaCount() {
		return teaList.size();
	}

	public int getBlendedCount() {
		return blendedList.size();
	}

	public int getOtherthingsCount() {
		return otherthingsList.size();
	}

}
