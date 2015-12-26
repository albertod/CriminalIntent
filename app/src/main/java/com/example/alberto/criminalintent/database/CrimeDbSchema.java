package com.example.alberto.criminalintent.database;

/**
 * Created by Alberto on 12/14/15.
 */
public class CrimeDbSchema {

    public static final class CrimeTable {
        public static final String NAME = "crimes";

        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String TITLE = "title";
            public static final String DATE = "date";
            public static final String SOLVED = "solver";
            public static final String SUSPECT = "suspect";
        }
    }
}
