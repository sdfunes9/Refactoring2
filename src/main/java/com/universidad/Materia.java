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
        for (int i=0; i < BdMaterias.listarMaterias().size(); i++ ){
            System.out.println("Indice: "+  (i) +  " Codigo: " + BdMaterias.listarMaterias().get(i).getIdMateria() + " " + "Materia: " + BdMaterias.listarMaterias().get(i).getNombreMateria());      }
    }

    @Override
    public String toString() {
        return "Materia{" +
                "idMateria='" + idMateria + '\'' +
                ", nombreMateria='" + nombreMateria + '\'' +
                ", horario='" + horario + '\'' +
                ", fechaInicio='" + fechaInicio + '\'' +
                ", fechaFin='" + fechaFin + '\'' +
                '}';
    }

    String dest;
    int nmateria;
    Scanner entrada = new Scanner(System.in);
    public  void mostrarInfo() throws FileNotFoundException {
        Scanner entrada = new Scanner(System.in);
        Maestro maestro = new Maestro();

        System.out.println(" ");
        String respuesta ="";
        System.out.println("Escriba la ruta de la carpeta donde quiere guardar el archivo:");
        String ruta = entrada.nextLine();
        System.out.println("Escriba el nombre del pdf");
        String filename = entrada.nextLine();
        dest = ruta+ File.separator + filename + ".pdf";

        File f = new File(dest);
        boolean exist = f.exists();

        if(exist == true) {
            System.out.println("Un archivo con este nombre ya existe ¿Quieres sobrescribir el archivo? si/no");
              respuesta = entrada.nextLine();
            if (respuesta.equals("si")) {
                creacionpdf();
            }
            else {
                mostrarInfo();
        }
    }
        else {
            creacionpdf();
        }
    }
        public void creacionpdf() throws FileNotFoundException {

        System.out.println("Escriba el indice de la materia:");
        nmateria = entrada.nextInt();

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

            System.out.println("Documento PDF creado");
        }

        public void guardarEnviar() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Desea enviar por correo o guardar en su computadora? (Ingrese 'enviar' o 'guardar')");
            System.out.print("> ");
            String respuesta = scanner.nextLine();

            if (respuesta.compareTo("enviar") == 0) {
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

            } else if (respuesta.compareTo("guardar") == 0) {
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
            Scanner scanner = new Scanner(System.in);
            Email email = new Email();

            System.out.println("Ingrese su direccion de correo.");
            System.out.print("> ");
            String destinatario = scanner.nextLine();
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
        }
    }





