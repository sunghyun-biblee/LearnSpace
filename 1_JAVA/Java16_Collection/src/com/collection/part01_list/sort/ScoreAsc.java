package com.collection.part01_list.sort;

import java.util.Comparator;

public class ScoreAsc implements Comparator<Score> {

	@Override
	public int compare(Score o1, Score o2) {
		// 점수 오름차순 정렬
				int other1 = o1.getScore();
				int other2 = o2.getScore();

				if (other1 > other2) {
					return 1;
				} else if (other1 < other2) {
					return -1;
				} else {
					return 0;
				}

			}

		}
