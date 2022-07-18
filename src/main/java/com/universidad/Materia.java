package com.universidad;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.universidad.utils.email.Email;
import com.universidad.utils.email.EmailService;
import com.universidad.utils.email.interfaces.EmailSender;
import com.universidad.utils.email.library.SimpleEmailSender;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Materia {

    @Setter
    @Getter
    private String idMateria;
    @Setter
    @Getter
    private String nombreMateria;
    @Setter
    @Getter
    private String horario;
    @Setter
    @Getter
    private String fechaInicio;
    @Setter
    @Getter
    private String fechaFin;
    public Materia(String idMateria, String nombreMateria, String horario, String fechaInicio, String fechaFin) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.horario = horario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Materia() {

    }
     public void mostrarmaterias(){
         String mats =  "Indice 0 " +BdMaterias.listarMaterias().get(0).nombreMateria +'\n' + "Indice 1: " + BdMaterias.listarMaterias().get(1).nombreMateria + '\n' + "Indice 2: " +BdMaterias.listarMaterias().get(2).nombreMateria +  '\n' + "Indice 3: " +BdMaterias.listarMaterias().get(3).nombreMateria +'\n' + "Indice 4: " +BdMaterias.listarMaterias().get(4).nombreMateria +'\n' + "Indice 5: " +BdMaterias.listarMaterias().get(5).nombreMateria +'\n' +"Indice 6: " +BdMaterias.listarMaterias().get(6).nombreMateria +'\n' + "Indice 7: " +BdMaterias.listarMaterias().get(7).nombreMateria;

         JOptionPane.showMessageDialog(null, mats,
                          "Empleado",JOptionPane.PLAIN_MESSAGE);

    }

    @Override
    public String toString() {
        return " Materia: " +'\n' +
                " idMateria: " + idMateria + '\n' +
                " nombreMateria: " + nombreMateria + '\n' +
                " horario: " + horario + '\n' +
                " fechaInicio: " + fechaInicio + '\n' +
                " fechaFin: " + fechaFin + '\n';
    }
    String dest;
    int nmateria;
    public void mostrarInfo() throws FileNotFoundException {

        String[] respuesta= {"SI", "NO"};
        String respuesta1 = "";
        String ruta = JOptionPane.showInputDialog(null,"Escriba la ruta de la carpeta donde quiere guardar el archivo:","Menu materias", JOptionPane.PLAIN_MESSAGE);
        String filename = JOptionPane.showInputDialog(null,"Escriba el nombre del pdf","Menu materia",JOptionPane.PLAIN_MESSAGE);
        dest = ruta + File.separator + filename + ".pdf";


        File f = new File(dest);
        boolean exist = f.exists();

        if (exist) {
           respuesta1 = (String) JOptionPane.showInputDialog(null,
                    "Un archivo con ese nombre ya existe, ¿Desea sobrescribirlo?", "SI O NO",
                    JOptionPane.DEFAULT_OPTION, null, respuesta, respuesta[0]);
            if (respuesta1.equals("SI")) {
                creacionpdf();

            } else {
                mostrarInfo();
            }
        } else {
            creacionpdf();
        }
    }
        public void creacionpdf() throws FileNotFoundException {

        mostrarmaterias();
        nmateria = Integer.parseInt(JOptionPane.showInputDialog(null,"Escriba el indice de la materia", "Menu Materia",JOptionPane.PLAIN_MESSAGE));
        Maestro maestro = new Maestro();
            //Crear pdf PdfWriter
            PdfWriter writer = new PdfWriter(dest);

            //Crear PdfDocument
            PdfDocument pdfDoc = new PdfDocument(writer);

            //Crear documento
            Document documento = new Document(pdfDoc);

            //creando tabla
            float[] pointColumnWidth = {150F, 150F};
            Table tabla = new Table(pointColumnWidth);

            //Agregando datos a la tabla
            //primera fila
            Cell cell1 = new Cell();
            cell1.add("ID de la materia");
            tabla.addCell(cell1);

            Cell cell2 = new Cell();
            cell2.add(BdMaterias.listarMaterias().get(nmateria).idMateria);
            tabla.addCell(cell2);

            //segunda fila
            Cell cell3 = new Cell();
            cell3.add("Materia");
            tabla.addCell(cell3);

            Cell cell4 = new Cell();
            cell4.add(BdMaterias.listarMaterias().get(nmateria).nombreMateria);
            tabla.addCell(cell4);

            //tercera fila
            Cell cell5 = new Cell();
            cell5.add("Maestro");
            tabla.addCell(cell5);

            Cell cell6 = new Cell();
            cell6.add(maestro.asignarmateriaimpartida().get(nmateria));
            tabla.addCell(cell6);

            //cuarta fila
            Cell cell7 = new Cell();
            cell7.add("Horario");
            tabla.addCell(cell7);

            Cell cell8 = new Cell();
            cell8.add(BdMaterias.listarMaterias().get(nmateria).horario);
            tabla.addCell(cell8);

            //quinta fila
            Cell cell9 = new Cell();
            cell9.add("Fecha de inicio");
            tabla.addCell(cell9);

            Cell cell10 = new Cell();
            cell10.add(BdMaterias.listarMaterias().get(nmateria).fechaInicio);
            tabla.addCell(cell10);

            //sexta fila
            Cell cell11 = new Cell();
            cell11.add("Fecha de finalizacion");
            tabla.addCell(cell11);

            Cell cell12 = new Cell();
            cell12.add(BdMaterias.listarMaterias().get(nmateria).fechaFin);
            tabla.addCell(cell12);

            documento.add(tabla);

            documento.close();

            JOptionPane.showMessageDialog(null,"Archivo PDF creado","PDF CREADO",JOptionPane.PLAIN_MESSAGE);
        }

        public void guardarEnviar() {

            String [] opciones = {"Enviar", "Guardar"};
            String opciones1 = "";

            opciones1 = (String) JOptionPane.showInputDialog(null,
                    "Desea enviar por correo o guardar en su computadora? (Ingrese 'enviar' o 'guardar')", "Guardar o Enviar",
                    JOptionPane.DEFAULT_OPTION, null, opciones, opciones[0]);

            if (opciones1.compareTo("Enviar") == 0) {
                // #######################################################################################################
                // Creamos el pdf
                // #######################################################################################################
                String tempDir = System.getProperty("java.io.tmpdir");
                Path tempPath = Paths.get(tempDir + "ProyectoSOLID\\PDFsGenerados\\");
                if (!Files.exists(tempPath)) {
                    try {
                        Files.createDirectories(tempPath);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                dest = tempPath + "\\" + "Reporte-" + Math.abs(new Random().nextInt()) + ".pdf";
                try {
                    creacionpdf();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

                String fileLocation = dest;
                enviarPorCorreo(fileLocation);

            } else if (opciones1.compareTo("Guardar") == 0) {
                try {
                    mostrarInfo();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public void enviarPorCorreo(String fileLocation) {
            // #######################################################################################################
            // Preparamos el correo
            // #######################################################################################################
            Email email = new Email();

            System.out.println("Ingrese su direccion de correo.");

            String destinatario = JOptionPane.showInputDialog(null,"Ingrese su direccion de correo", "CORREO",JOptionPane.PLAIN_MESSAGE);

            email.addRecipient(destinatario);

            email.setSubject("Reporte de Datos de Materia");
            email.setMessage("No responda a este mensaje. \n\n\n" +
                    "Reporte generado para materia: " + BdMaterias.listarMaterias().get(nmateria).nombreMateria);
            email.addAttachment(new File(fileLocation));

            // #######################################################################################################
            // En esta seccion se realiza el envio
            // #######################################################################################################
            EmailSender emailSender = SimpleEmailSender.getDefaultInstance();
            EmailService emailService = new EmailService(emailSender);
            emailService.sendEmail(email);
            JOptionPane.showMessageDialog(null,"Se envio correctamente","Message",JOptionPane.PLAIN_MESSAGE);
        }
    }





