package com.allsafe.demo.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Configuration
@EnableScheduling
public class WebStatusImpl {
	@Autowired
	private WebStatusService webStatusService;
	int x=0;
	File file=new File("F:\\SPRING PROJECTS\\RealTimeWebApp\\src\\main\\resources\\static\\newjason.json");
	public void FileWrite() {
		try {
//			file = new File("F:\\SPRING PROJECTS\\RealTimeWebApp\\src\\main\\resources\\static\\newjason.json");
			boolean fvar = file.createNewFile();
			if (fvar) {
				System.out.println("File has been created successfully");
			} else {
				System.out.println("File already present at the specified location");
			}
			FileWriter fr = new FileWriter(file, false);
			BufferedWriter br = new BufferedWriter(fr);
			br.write("[[0,0]]");
			System.out.println("file creation completed");
			x=0;
			br.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private final AtomicBoolean enabled = new AtomicBoolean(false);

	@Scheduled(fixedRate = 1000)
	public void runFileWriter() {
		if (enabled.get()) {
			int y = webStatusService.RunStatus();
			try {
//				file = new File(
//						"F:\\SPRING PROJECTS\\RealTimeWebApp\\src\\main\\resources\\static\\newjason.json");
				Scanner scanner = new Scanner(file).useDelimiter("\n");
				String line = scanner.next();
				String newLine = line.replaceFirst("]]", "],[" + x + "," + y + "]]");
				FileWriter writer = new FileWriter(file);
				writer.write(newLine);
				writer.close();
				System.out.println("x : " + x + " y: " + y);
				x++;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	public void toggle(boolean t) {
        enabled.set(t);
	}
}
