package com.example.myapplication;

public class FactionSchema
{
    public static class FactionTable
    {
        public static final String NAME = "factions";
        public static class Cols
        {
            public static final String ID = "faction_id";
            public static final String NAME = "name";
            public static final String STRENGTH = "strength";
            public static final String RELATIONSHIP = "relationship";
        }
    }
}
