package br.pro.delfino.drogaria.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder; 
 
public class HibernateUtil {
 private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();

 public static SessionFactory getFabricaDeSessoes() {
  return fabricaDeSessoes;
 }

 private static SessionFactory criarFabricaDeSessoes() {
  try {
   StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
   Metadata metaData = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
   return fabricaDeSessoes = metaData.getSessionFactoryBuilder().build();
  } catch (Throwable ex) {
   System.err.println("A fábrica de sessões não pode ser criada." + ex);
   throw new ExceptionInInitializerError(ex);
  }
 }
}