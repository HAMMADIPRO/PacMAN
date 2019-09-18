/**
	pacmanjava
    @autor Yassine HAMMADI 
	Created on 17 Sep 2019 at 13:44:54
 */
package gfx;


public class Score {

	private int nbLife;
	private int score ;

	public int getNbLife() {
		return nbLife;
	}

	public void setNbLife(int nbrLife) {
		nbLife = nbrLife;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Score(int nbrV, int score) {
		super();
		nbLife = nbrV;
		this.score = score;
	}

	public Score() {
		this.score =0;
		this.nbLife=3;
	}

	public void bonusGum() {
		this.setScore(this.getScore()+1);
	}

	public void bonusPacGum(){
		this.setScore(this.getScore()+10);
	}

	public void bonusFruit() {
		this.setScore(this.getScore()+50);
	}

	public void totalScore() {
		this.toString();
	}

	@Override
	public String toString() {




		if(score>99) {
			return "0" + score ;
		}

		else if(score>9) {
			return "00" + score ;
		}

		else if(score>0) {
			return "000" + score ;

		}

		return "0000"+score;
	}



}
