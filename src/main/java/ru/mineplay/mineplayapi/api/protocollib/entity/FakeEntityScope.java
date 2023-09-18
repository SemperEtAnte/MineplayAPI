package ru.mineplay.mineplayapi.api.protocollib.entity;

public enum FakeEntityScope {

    /**
     * Существо с данной видимостью будет
     * виден всем игрокам в сети, и даже новым,
     * таким образом его не нужно спавнить
     * вручную, создавая новые объекты
     */
    PUBLIC,

    /**
     * Существо с прототипной видимостью
     * необходимо спавнить вручную
     */
    PROTOTYPE,

}
