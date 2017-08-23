package com.libertymutual.ioisgreat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IoIsGreatApplication {

	public static void main(String[] args) {
		SpringApplication.run(IoIsGreatApplication.class, args);
		// FileReader reader = null;
		// BufferedReader buffy = null;

		try (FileReader reader = new FileReader("text.txt");
				BufferedReader buffy = new BufferedReader(reader);
				FileWriter writer = new FileWriter("text-copy.txt");
				BufferedWriter pumpy = new BufferedWriter(writer)) { // try with resources - java will put in a finally
																		// block for us which closes the things
			// reader = new FileReader("text.txt");
			System.out.println("Everything is ok.");

			// buffy = new BufferedReader(reader);
			String line = buffy.readLine();

			while (line != null) {
				System.out.println(line);
				pumpy.write(line);
				line = buffy.readLine();
				pumpy.newLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("Could not find file.");

		} catch (IOException e) {
			System.out.println("Could not read file.");
		}
	}

}
