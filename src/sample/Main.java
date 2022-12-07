package sample;

import DataStructure.Hash;
import DataStructure.Heap;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import project.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Main extends Application {

    ArrayList<FileRead> arrObjFile = new ArrayList();
    Calculation objCalc;
    String filePath = "";
    int numberFile = 0;
    int hashSize = 0;
    Hash hashBaby;
    int flag = -1;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene(root, 1000, 800, Color.web("#9D9B9B"));

        //Creat button Browse files
        Button btnBrowseFiles = new Button();
        btnBrowseFiles.setText("Browse file");

        //Creat button for read files
        Button btnReadFiles = new Button();
        btnReadFiles.setText("Read files");

        //Hbox for button read and browse
        HBox hBoxBrowseRead = new HBox(btnBrowseFiles, btnReadFiles);
        hBoxBrowseRead.setSpacing(30);
        //hBoxBrowseRead.setLayoutY(60);
        //hBoxBrowseRead.setLayoutX(100);
        //root.getChildren().add(hBoxBrowseRead);

        //Text area for name files
        TextArea textAreaFile = new TextArea();
        textAreaFile.setEditable(false);
        textAreaFile.setPrefHeight(100);
        textAreaFile.setPrefWidth(350);

        //VBox for hBoxBrowseRead and text area file
        VBox vBoxBrowseReadTextArea = new VBox(hBoxBrowseRead, textAreaFile);
        vBoxBrowseReadTextArea.setLayoutX(60);
        vBoxBrowseReadTextArea.setLayoutY(20);
        vBoxBrowseReadTextArea.setSpacing(15);
        root.getChildren().add(vBoxBrowseReadTextArea);

        //////////////////////////////////////////////

        //Creat button for add new name/gender record
        Button btnAdd1 = new Button();
        btnAdd1.setText("Add name/gender");

        //text field for add new name/gender
        TextField txtAdd1_Name = new TextField();
        txtAdd1_Name.setText("");
        txtAdd1_Name.setPrefColumnCount(15);
        txtAdd1_Name.setPromptText("Enter name");

        ToggleGroup tglRadioBtn0 = new ToggleGroup();

        //Radio button for add new name/gender Female
        RadioButton radioBtn_NameGender_F = new RadioButton();
        radioBtn_NameGender_F.setText("F");
        radioBtn_NameGender_F.setToggleGroup(tglRadioBtn0);

        //Radio button for add new name/gender Male
        RadioButton radioBtn_NameGender_M = new RadioButton();
        radioBtn_NameGender_M.setText("M");
        radioBtn_NameGender_M.setToggleGroup(tglRadioBtn0);

        //Hbox for radio button Male and female
        HBox hBoxRadioBtn_AddGender1 = new HBox(radioBtn_NameGender_F, radioBtn_NameGender_M);
        hBoxRadioBtn_AddGender1.setSpacing(20);

        //Vbox for add1 result
        VBox vBoxAdd1Result = new VBox(txtAdd1_Name, hBoxRadioBtn_AddGender1);
        vBoxAdd1Result.setSpacing(15);
        //root.getChildren().add(vBoxAdd1Result);

        //Hbox for add button and resutl
        HBox hBoxAddBtn1Result = new HBox(btnAdd1, vBoxAdd1Result);
        hBoxAddBtn1Result.setSpacing(30);
        //root.getChildren().add(hBoxAddBtn1Result);

        //Creat button for add new names year/freq record
        Button btnAdd2 = new Button();
        btnAdd2.setText("Add year/freq");

        //text filed for name add2
        TextField txtAdd2_Name = new TextField();
        txtAdd2_Name.setText("");
        txtAdd2_Name.setPrefColumnCount(15);
        txtAdd2_Name.setPromptText("Enter name");

        ToggleGroup tglRadioBtn1 = new ToggleGroup();

        //Radio button for add2 new name/gender Female
        RadioButton radioBtn_add2_F = new RadioButton();
        radioBtn_add2_F.setText("F");
        radioBtn_add2_F.setToggleGroup(tglRadioBtn1);

        //Radio button for add2 new name/gender Male
        RadioButton radioBtn_add2_M = new RadioButton();
        radioBtn_add2_M.setText("M");
        radioBtn_add2_M.setToggleGroup(tglRadioBtn1);

        //Hbox for radio button Male and female
        HBox hBoxRadioBtn_AddGender2 = new HBox(radioBtn_add2_F, radioBtn_add2_M);
        hBoxRadioBtn_AddGender2.setSpacing(20);

        //text filed for year add2
        TextField txtAdd2_Year = new TextField();
        txtAdd2_Year.setText("");
        txtAdd2_Year.setPrefColumnCount(15);
        txtAdd2_Year.setPromptText("Enter year");

        //text filed for freq add2
        TextField txtAdd2_Freq = new TextField();
        txtAdd2_Freq.setText("");
        txtAdd2_Freq.setPrefColumnCount(15);
        txtAdd2_Freq.setPromptText("Enter freq");

        VBox vBoxAdd2Result = new VBox(txtAdd2_Name, hBoxRadioBtn_AddGender2, txtAdd2_Year, txtAdd2_Freq);
        vBoxAdd2Result.setSpacing(15);

        HBox hboxAdd2Result = new HBox(btnAdd2, vBoxAdd2Result);
        hboxAdd2Result.setSpacing(53);
        //root.getChildren().add(hboxAdd2Result);

        //Creat button for delete name record
        Button btnDeleteName = new Button();
        btnDeleteName.setText("Delete record");

        //text field for delete
        TextField txtDeleteName = new TextField();
        txtDeleteName.setText("");
        txtDeleteName.setPrefColumnCount(15);
        txtDeleteName.setPromptText("Enter name");

        ToggleGroup tglRadioBtn2 = new ToggleGroup();

        //Radio button for delete name F
        RadioButton radioBtn_Delete_F = new RadioButton();
        radioBtn_Delete_F.setText("F");
        radioBtn_Delete_F.setToggleGroup(tglRadioBtn2);

        //Radio button for delete name M
        RadioButton radioBtn_Delete_M = new RadioButton();
        radioBtn_Delete_M.setText("M");
        radioBtn_Delete_M.setToggleGroup(tglRadioBtn2);

        //Hbox for radio button Male and female delete
        HBox hBoxRadioBtn_delete = new HBox(radioBtn_Delete_F, radioBtn_Delete_M);
        hBoxRadioBtn_delete.setSpacing(20);

        //Vbox delete result
        VBox vBoxDeleteResult = new VBox(txtDeleteName, hBoxRadioBtn_delete);
        vBoxDeleteResult.setSpacing(15);

        //Hbox for btn delete and result
        HBox hBoxDeleteResult = new HBox(btnDeleteName, vBoxDeleteResult);
        hBoxDeleteResult.setSpacing(52);

        //Creat button for update names year/freq
        Button btnUpdateYearFreq = new Button();
        btnUpdateYearFreq.setText("Update year/freq");

        //text field for update name
        TextField txtUpdateName = new TextField();
        txtUpdateName.setText("");
        txtUpdateName.setPrefColumnCount(15);
        txtUpdateName.setPromptText("Enter name");

        ToggleGroup tglRadioBtn3 = new ToggleGroup();

        //Radio button for update  F
        RadioButton radioBtn_Update_F = new RadioButton();
        radioBtn_Update_F.setText("F");
        radioBtn_Update_F.setToggleGroup(tglRadioBtn3);

        //Radio button for update M
        RadioButton radioBtn_Update_M = new RadioButton();
        radioBtn_Update_M.setText("M");
        radioBtn_Update_M.setToggleGroup(tglRadioBtn3);

        //Hbox for radio button Male and female delete
        HBox hBoxRadioBtn_Update = new HBox(radioBtn_Update_F, radioBtn_Update_M);
        hBoxRadioBtn_Update.setSpacing(20);

        //text field for update old year
        TextField txtUpdateOldYear = new TextField();
        txtUpdateOldYear.setText("");
        txtUpdateOldYear.setPrefColumnCount(15);
        txtUpdateOldYear.setPromptText("Enter old year");

        //text field for update name
        TextField txtUpdateNewYear = new TextField();
        txtUpdateNewYear.setText("");
        txtUpdateNewYear.setPrefColumnCount(15);
        txtUpdateNewYear.setPromptText("Enter new year");

        //text field for update frea
        TextField txtUpdateFreq = new TextField();
        txtUpdateFreq.setText("");
        txtUpdateFreq.setPrefColumnCount(15);
        txtUpdateFreq.setPromptText("Enter new freq");

        //Vbox update result
        VBox vBoxUpdateResult = new VBox(txtUpdateName, hBoxRadioBtn_Update, txtUpdateOldYear, txtUpdateNewYear, txtUpdateFreq);
        vBoxUpdateResult.setSpacing(13);

        //Hbox for update btn and result
        HBox hBoxBtnUpdateResults = new HBox(btnUpdateYearFreq, vBoxUpdateResult);
        hBoxBtnUpdateResults.setSpacing(30);

        //////////////////////////////////////////////////////

        Button btnSearch = new Button();
        btnSearch.setText("Search");

        TextField txtSearchName = new TextField();
        txtSearchName.setText("");
        txtSearchName.setPrefColumnCount(15);
        txtSearchName.setPromptText("Enter Name");

        ToggleGroup tglRadioBtn4 = new ToggleGroup();

        //Radio button for search  F
        RadioButton radioBtnSearch_F = new RadioButton();
        radioBtnSearch_F.setText("F");
        radioBtnSearch_F.setToggleGroup(tglRadioBtn4);

        //Radio button for search M
        RadioButton radioBtnSearch_M = new RadioButton();
        radioBtnSearch_M.setText("M");
        radioBtnSearch_M.setToggleGroup(tglRadioBtn4);

        //Hbox for radio button Male and female search
        HBox hBoxRadioBtn_Search = new HBox(radioBtnSearch_F, radioBtnSearch_M);
        hBoxRadioBtn_Search.setSpacing(20);

        //Vbox Search result
        VBox vBoxSearch = new VBox(txtSearchName, hBoxRadioBtn_Search);
        vBoxSearch.setSpacing(15);

        //Hbox for update btn and result
        HBox hBoxBtnSearch = new HBox(btnSearch, vBoxSearch);
        hBoxBtnSearch.setSpacing(30);
        hBoxBtnSearch.setLayoutY(620);
        hBoxBtnSearch.setLayoutX(580);
        root.getChildren().add(hBoxBtnSearch);
        ////////////////////////

        TextArea textAreaSearch = new TextArea();
        textAreaSearch.setEditable(false);
        textAreaSearch.setPrefHeight(50);
        textAreaSearch.setPrefWidth(430);
        textAreaSearch.setLayoutX(550);
        textAreaSearch.setLayoutY(700);
        root.getChildren().add(textAreaSearch);


        //////////////////////////////////////////////////////////
        Button btnShowMax = new Button();
        btnShowMax.setText("Show");


        //txt field for year show max
        TextField txtShowMaxYear = new TextField();
        txtShowMaxYear.setText("");
        txtShowMaxYear.setPrefColumnCount(15);
        txtShowMaxYear.setPromptText("Enter Year");


        //Hbox for show btn and result
        HBox hBoxBtnShow = new HBox(btnShowMax, txtShowMaxYear);
        hBoxBtnShow.setSpacing(30);
        hBoxBtnShow.setLayoutY(450);
        hBoxBtnShow.setLayoutX(580);
        root.getChildren().add(hBoxBtnShow);


        ////////////
        TextArea textAreaShow = new TextArea();
        textAreaShow.setEditable(false);
        textAreaShow.setPrefHeight(50);
        textAreaShow.setPrefWidth(430);
        textAreaShow.setLayoutX(550);
        textAreaShow.setLayoutY(505);
        root.getChildren().add(textAreaShow);


        ////////////////////////////////////////////////

        Text textBabyRecord = new Text();
        textBabyRecord.setText("Baby's Record");
        textBabyRecord.setX(600);
        textBabyRecord.setY(200);
        //root.getChildren().add(textBabyRecord);
        //////////////////////////////////////


        ///////////////////Set on action buttons//////////////////

        //Button browse file set on action
        btnBrowseFiles.setOnAction(event -> {

            String path;
            int year = 0;


            TextInputDialog dialog = new TextInputDialog("2018");
            dialog.setTitle("Year Chooser");
            dialog.setHeaderText(null);
            dialog.setContentText("Please enter year :");


            Optional<String> result = dialog.showAndWait();
            if (result.isPresent()) {

                year = Integer.parseInt(result.get());

                FileChooser fileChooserShares = new FileChooser();
                fileChooserShares.setTitle("Select shares file .txt");
                fileChooserShares.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                        new FileChooser.ExtensionFilter("Text Document", "*.java")
                );

                File selectedFile = fileChooserShares.showOpenDialog(primaryStage);
                if (String.valueOf(selectedFile).equals("null")) {
                    return;
                } else {
                    path = selectedFile.getPath().trim().toString();
                    //textAreaFile.setText(selectedFile.toString());
                }

                arrObjFile.add(new FileRead(path, year));
            }

            int count = 1;
            for (int i = 0; i < arrObjFile.size(); i++) {
                filePath = filePath + count + ". " + arrObjFile.get(i).toString() + "\n";
                count++;
            }

            textAreaFile.setText(filePath);
            filePath = "";
            numberFile++;


            // result.ifPresent(name -> System.out.println("Your name: " + name));


        });

        //Button read file set on action
        btnReadFiles.setOnAction(event -> {

            try {

                // read first file to know number of line
                //the ( number of line * 2 .next prime.) is well be the size for the hash
                File file1 = new File(arrObjFile.get(0).getPath());
                Scanner scanner = new Scanner(file1);

                while (scanner.hasNext()) {
                    String line = scanner.nextLine();
                    //System.out.println(line);
                    hashSize++;

                }

                hashSize = hashSize * 2;
                hashSize = nextPrimeH(hashSize);
                //System.out.println( "hash size = " + hashSize);

                hashBaby = new Hash(hashSize);
                //hashBaby.printHashTable();

                /////// Store data in hash and heap /////////////////

                for (int i = 0; i < arrObjFile.size(); i++) {

                    File file = new File(arrObjFile.get(i).getPath());
                    Scanner scan = new Scanner(file);

                    while (scan.hasNext()) {

                        String line = scan.nextLine();
                        String[] lineSplit = line.split(",");

                        String name = lineSplit[0];
                        String gender = lineSplit[1];
                        String freq = lineSplit[2];

                        if (hashBaby.getCurrentSize() == 1) {
                            FreqYear objFreq = new FreqYear(Integer.parseInt(freq), arrObjFile.get(i).getYear());
                            Heap<FreqYear> heap = new Heap<>(numberFile + 1);
                            heap.insert(objFreq);
                            Baby obj = new Baby(name, gender.charAt(0), heap);
                            int ascii = getAscii(name.trim().concat(gender.trim()));
                            hashBaby.insert(ascii, obj);

                        }//Big if statement
                        else {

                            int check = isNameFound(hashBaby, name, gender.charAt(0));
                            if (check == -1) {

                                FreqYear objFreq = new FreqYear(Integer.parseInt(freq), arrObjFile.get(i).getYear());
                                Heap<FreqYear> heap = new Heap<>(numberFile);
                                heap.insert(objFreq);
                                Baby obj = new Baby(name, gender.charAt(0), heap);
                                int ascii = getAscii(name.trim().concat(gender.trim()));
                                hashBaby.insert(ascii, obj);
                                //System.out.println("if");

                            } else {

                                Baby obj = hashBaby.updateFreq(check, name.trim(), gender.charAt(0));
                                FreqYear o = new FreqYear(Integer.parseInt(freq), arrObjFile.get(i).getYear());
                                obj.getHeapFrequency().insert(o);

                                //System.out.println("else");

                            }//else

                        }//Big else statement

                    }//While loop

                }//for loop

                //hashBaby.printHashTable();


                flag = 0;

                Alert alertCreat = new Alert(Alert.AlertType.INFORMATION);
                alertCreat.setTitle("Information");
                alertCreat.setHeaderText(null);
                alertCreat.setContentText("Files read successfully ...");
                alertCreat.showAndWait();


            } catch (FileNotFoundException e) {
                Alert alertCreat = new Alert(Alert.AlertType.ERROR);
                alertCreat.setTitle("Error");
                alertCreat.setHeaderText(null);
                alertCreat.setContentText(e.getMessage());
                alertCreat.showAndWait();
            }


        });


        //Button add1 new name record set on action
        btnAdd1.setOnAction(event -> {

            if (flag == 0) {

                String name = txtAdd1_Name.getText().trim();
                String gender = "";
                if (radioBtn_NameGender_M.isSelected())
                    gender = "M";
                else if (radioBtn_NameGender_F.isSelected())
                    gender = "F";

                int ascii = getAscii(name.trim().concat(gender.trim()));
                int check = hashBaby.search(ascii, name, gender.charAt(0));

                if (check == -1) {

                    hashBaby.insert(ascii, new Baby(name, gender.charAt(0), new Heap<FreqYear>(numberFile)));
                    //hashBaby.printHashTable();

                    Alert alertCreat = new Alert(Alert.AlertType.INFORMATION);
                    alertCreat.setTitle("Information");
                    alertCreat.setHeaderText(null);
                    alertCreat.setContentText("Name record {  " + name + " , " + gender + " }\nThe record has been added successfully");
                    alertCreat.showAndWait();

                } else {

                    Alert alertCreat = new Alert(Alert.AlertType.WARNING);
                    alertCreat.setTitle("Warning");
                    alertCreat.setHeaderText(null);
                    alertCreat.setContentText("Name record { " + name + " , " + gender + " }\nYou cannot add an existing record !!");
                    alertCreat.showAndWait();

                }

            } else {

                Alert alertCreat = new Alert(Alert.AlertType.WARNING);
                alertCreat.setTitle("Warning");
                alertCreat.setHeaderText(null);
                alertCreat.setContentText("There is no data readed !!");
                alertCreat.showAndWait();

            }


        });

        //Button delete set on action
        btnDeleteName.setOnAction(event -> {

            if (flag == 0) {

                if (hashBaby.getCurrentSize() == 1) {

                    Alert alertCreat = new Alert(Alert.AlertType.WARNING);
                    alertCreat.setTitle("Warning");
                    alertCreat.setHeaderText(null);
                    alertCreat.setContentText("There is no record's to delete it");
                    alertCreat.showAndWait();

                } else {

                    hashBaby.printHashTable();

                    String name = txtDeleteName.getText().trim();
                    String gender;
                    if (radioBtn_Delete_F.isSelected())
                        gender = "F";
                    else
                        gender = "M";

                    int ascii = getAscii(name.trim().concat(gender.trim()));
                    int check = hashBaby.search(ascii, name, gender.charAt(0));
                    if (check == -1) {


                        Alert alertCreat = new Alert(Alert.AlertType.WARNING);
                        alertCreat.setTitle("Warning");
                        alertCreat.setHeaderText(null);
                        alertCreat.setContentText("Name record {  " + name + " , " + gender + " }\nRecord not found !!");
                        alertCreat.showAndWait();

                    } else {

                        hashBaby.deleteNameRecord(ascii, name, gender.charAt(0));

                        Alert alertCreat = new Alert(Alert.AlertType.INFORMATION);
                        alertCreat.setTitle("Information");
                        alertCreat.setHeaderText(null);
                        alertCreat.setContentText("Name record { " + name + " , " + gender + " }\nThe record has been removed successfully");
                        alertCreat.showAndWait();

                    }
                    System.out.println();
                    System.out.println("/////////////////////////////");
                    System.out.println();
                    hashBaby.printHashTable();

                }
            } else {

                Alert alertCreat = new Alert(Alert.AlertType.WARNING);
                alertCreat.setTitle("Warning");
                alertCreat.setHeaderText(null);
                alertCreat.setContentText("There is no data readed !!");
                alertCreat.showAndWait();

            }


        });

        //Button Update set On Action
        btnUpdateYearFreq.setOnAction(event -> {

            if (flag == 0) {

                String name = txtUpdateName.getText().trim();
                String gender;
                if (radioBtn_Update_F.isSelected())
                    gender = "F";
                else
                    gender = "M";


                int ascii = getAscii(name.trim().concat(gender.trim()));
                int check = hashBaby.search(ascii, name, gender.charAt(0));
                int oldYear = Integer.parseInt(txtUpdateOldYear.getText().trim());
                int newYear = Integer.parseInt(txtUpdateNewYear.getText().trim());

                if (check == -1) {

                    Alert alertCreat = new Alert(Alert.AlertType.WARNING);
                    alertCreat.setTitle("Warning");
                    alertCreat.setHeaderText(null);
                    alertCreat.setContentText("The record not found !!");
                    alertCreat.showAndWait();

                } else {

                    Baby objBaby = hashBaby.updateFreq(ascii, name, gender.charAt(0));
                    FreqYear objFreq = objBaby.getHeapFrequency().findOldYear(Integer.parseInt(txtUpdateOldYear.getText()));

                    if (objFreq.getYear() == 0) {

                        Alert alertCreat = new Alert(Alert.AlertType.WARNING);
                        alertCreat.setTitle("Warning");
                        alertCreat.setHeaderText(null);
                        alertCreat.setContentText("Year not found");
                        alertCreat.showAndWait();

                    } else {

                        objFreq.setFreq(Integer.parseInt(txtUpdateFreq.getText()));
                        objFreq.setYear(Integer.parseInt(txtUpdateNewYear.getText()));

                        Alert alertCreat = new Alert(Alert.AlertType.INFORMATION);
                        alertCreat.setTitle("Information");
                        alertCreat.setHeaderText(null);
                        alertCreat.setContentText("Freq and Year has been updated\n" +
                                "Name : " + objBaby.getName() + "\n" +
                                "Gender : " + objBaby.getGender() + "\n" +
                                "Heap Freq : " + objBaby.getHeapFrequency().getHeap());
                        alertCreat.showAndWait();

                    }


                }
            } else {

                Alert alertCreat = new Alert(Alert.AlertType.WARNING);
                alertCreat.setTitle("Warning");
                alertCreat.setHeaderText(null);
                alertCreat.setContentText("There is no data readed !!");
                alertCreat.showAndWait();


            }

            hashBaby.printHashTable();


        });

        //Button add2 new Freq and year set on action
        btnAdd2.setOnAction(event -> {

            if (flag == 0) {

                String name = txtAdd2_Name.getText().trim();
                String gender;
                if (radioBtn_add2_F.isSelected())
                    gender = "F";
                else
                    gender = "M";

                int ascii = getAscii(name.trim().concat(gender.trim()));
                int check = hashBaby.search(ascii, name, gender.charAt(0));
                if (check == -1) {


                    Alert alertCreat = new Alert(Alert.AlertType.WARNING);
                    alertCreat.setTitle("Warning");
                    alertCreat.setHeaderText(null);
                    alertCreat.setContentText("Name record {  " + name + " , " + gender + " }\nRecord not found !!");
                    alertCreat.showAndWait();

                } else {

                    Baby objBaby = hashBaby.updateFreq(ascii, name, gender.charAt(0));
                    FreqYear checkObj = objBaby.getHeapFrequency().findOldYear(Integer.parseInt(txtAdd2_Year.getText()));

                    System.out.println("check year = " + checkObj.toString());

                    if (checkObj.getYear() == 0) {


                        FreqYear newObj = new FreqYear(Integer.parseInt(txtAdd2_Freq.getText()), Integer.parseInt(txtAdd2_Year.getText()));
                        objBaby.getHeapFrequency().insert(newObj);

                        Alert alertCreat = new Alert(Alert.AlertType.INFORMATION);
                        alertCreat.setTitle("Information");
                        alertCreat.setHeaderText(null);
                        alertCreat.setContentText("new freq and year is entered");
                        alertCreat.showAndWait();

                        hashBaby.printHashTable();


                    } else {

                        Alert alertCreat = new Alert(Alert.AlertType.WARNING);
                        alertCreat.setTitle("Warning");
                        alertCreat.setHeaderText(null);
                        alertCreat.setContentText("Year exist !!");
                        alertCreat.showAndWait();

                    }


                }
            } else {


                Alert alertCreat = new Alert(Alert.AlertType.WARNING);
                alertCreat.setTitle("Warning");
                alertCreat.setHeaderText(null);
                alertCreat.setContentText("There is no data readed !!");
                alertCreat.showAndWait();


            }


        });

        //btn search set on action
        btngender = "F";
        Search.setOnAction(event -> {

            if (flag == 0) {

                String name = txtSearchName.getText();
                String gender;
                if (radioBtnSearch_F.isSelected())

                else
                gender = "M";
                int ascii = getAscii(name.trim().concat(gender.trim()));
                int location = hashBaby.search(ascii, name, gender.charAt(0));


                if (location == -1) {

                    Alert alertCreat = new Alert(Alert.AlertType.WARNING);
                    alertCreat.setTitle("Warning");
                    alertCreat.setHeaderText(null);
                    alertCreat.setContentText("Record not found");
                    alertCreat.showAndWait();

                } else {

                    Baby checkObj = hashBaby.table[location].getData();


                    //textAreaSearch.setText(checkObj.toString());
                    Heap newHeap = checkObj.getHeapFrequency().cloneHeap();
                    String freqStr = newHeap.HeapSort(newHeap);
                    System.out.println("freqstr  = " + freqStr);
                    textAreaSearch.setText("Name : " + checkObj.getName() + " , Gender : " + checkObj.getGender() + "\n" +
                            freqStr);

                    /*
                    if (newHeap.size < 2) {
                        System.out.println("1");
                        newHeap.print();
                        textAreaSearch.setText("Name : " + checkObj.getName() + " , Gender : " + checkObj.getGender() + "\n" +
                                checkObj.getHeapFrequency().getHeap());

                    } else {
                        System.out.println("2");
                        String freqStr = newHeap.HeapSort(newHeap);
                        System.out.println("freqstr  = " + freqStr);
                        textAreaSearch.setText("Name : " + checkObj.getName() + " , Gender : " + checkObj.getGender() + "\n" +
                                freqStr);
                    }

                     */

                }
            } else {

                Alert alertCreat = new Alert(Alert.AlertType.WARNING);
                alertCreat.setTitle("Warning");
                alertCreat.setHeaderText(null);
                alertCreat.setContentText("There is no data readed !!");
                alertCreat.showAndWait();

            }


        });

        //btn show max set on action
        btnShowMax.setOnAction(event -> {

            if (flag == 0) {

                int year = Integer.parseInt(txtShowMaxYear.getText().trim());
                Baby obj = hashBaby.getMaxNameInYear(year);
                int check = obj.getHeapFrequency().findFreq(year);

                if (check == 0) {

                    Alert alertCreat = new Alert(Alert.AlertType.WARNING);
                    alertCreat.setTitle("Warning");
                    alertCreat.setHeaderText(null);
                    alertCreat.setContentText("Year not found");
                    alertCreat.showAndWait();

                } else {
                    //System.out.println(obj);
                    textAreaShow.setText(obj.getName() + " has a maximum of " + obj.getHeapFrequency().findFreq(year) + " in " + year);
                }
            } else {

                Alert alertCreat = new Alert(Alert.AlertType.WARNING);
                alertCreat.setTitle("Warning");
                alertCreat.setHeaderText(null);
                alertCreat.setContentText("There is no data readed !!");
                alertCreat.showAndWait();
            }


        });


        ///////////////////////////////////
        VBox vBoxAll = new VBox(hBoxAddBtn1Result, hboxAdd2Result, hBoxDeleteResult, hBoxBtnUpdateResults);
        vBoxAll.setSpacing(40);
        vBoxAll.setLayoutY(200);
        vBoxAll.setLayoutX(60);
        root.getChildren().add(vBoxAll);


        root.getStylesheets().add(getClass().getResource("application.css").toExternalForm());


        primaryStage.setScene(scene);
        primaryStage.setFullScreen(false);
        primaryStage.setTitle("Baby's Record");
        primaryStage.setMaxHeight(1000);
        primaryStage.setMinHeight(1000);
        primaryStage.setMinWidth(1100);
        primaryStage.setMaxWidth(1100);
        primaryStage.show();

    }

    public static int getAscii(String word) {

        char[] charArr = word.toCharArray();
        int asciiValue = 0, sum = 0;

        for (int i = 0; i < charArr.length; i++) {
            asciiValue = (int) charArr[i];
            sum = sum + asciiValue;

        }

        //System.out.println(sum);
        return sum;

    }

    public static int isNameFound(Hash hash, String name, char gender) {

        int check = hash.search(getAscii(name.concat(String.valueOf(gender))), name, gender);
        if (check == -1) {
            return -1;
        } else
            return check;

    }

    public boolean isPrimeH(int n) {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n / 2; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }

    public int nextPrimeH(int n) {
        if (n % 2 == 0)
            n++;
        while (!isPrimeH(n)) {
            n += 2;
        }
        return n;
    }


    public static void main(String[] args) {
        launch(args);
    }


}
