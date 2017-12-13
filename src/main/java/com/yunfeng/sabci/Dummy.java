/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yunfeng.sabci;

import com.github.jtendermint.jabci.socket.TSocket;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author NewBreach
 */
public class Dummy {
    private static final String ABCI_CONFIG_DIR="/abciconfig";
     public static void main(String[] args) throws InterruptedException, IOException{
         String cmds="node";
         if(args.length!=0){
             cmds=args[0];
         }
        switch (cmds) {
            case "node":
//                java.io.File cf= new java.io.File(ABCI_CONFIG_DIR+"/config.json");
//                if(!cf.exists()){
//                    System.out.println("you need init config;");
//                    return ;
//                }
                System.out.println("StartDummy !");
                new Dummy().startDummy();
                break;
            case "init":
                java.io.File dir= new java.io.File(ABCI_CONFIG_DIR);
                if(!dir.exists()){ dir.mkdir();}
                java.io.File configFile= new java.io.File(ABCI_CONFIG_DIR+"/config.json");
                if(configFile.exists()){
                    System.out.println("file exists");
                }else{
                    System.out.println("create config file");
                    try (FileWriter fw = new FileWriter(configFile)) {
                        fw.write("{\"port\":\"46658\"}");
                        fw.flush();
                    }
                }   break;
            default:
                System.out.println("未知的参数: "+cmds);
                break;
        }
     }
    private void startDummy() throws InterruptedException {
        final TSocket sock = new TSocket();
        Thread mainThread = new Thread(sock::start);
        mainThread.setDaemon(true);
        mainThread.start();
        while(true){
          Thread.sleep(1000L);
        }
    }
}
