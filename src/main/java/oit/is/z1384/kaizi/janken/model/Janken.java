package oit.is.z1384.kaizi.janken.model;
public class Janken{
  public static int playjanken(int myhand) {
    int cpuhand = 0;
    int result = (myhand - cpuhand + 3) % 3;
    return result;
  }
}
