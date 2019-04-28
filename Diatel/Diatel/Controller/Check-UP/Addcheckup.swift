//
//  Addcheckup.swift
//  Diatel
//
//  Created by M.A.R.G on 2/7/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit
import McPicker


enum patientStatus {
    case normal
    case danger
    case alarm
}

class Addcheckup: UIViewController {

    @IBOutlet weak var sugarAmount: UITextField!
    @IBOutlet weak var timeTest: UIButton!
    @IBOutlet weak var checkboxcontainer: UIView!
    @IBOutlet weak var sickInPast: UIButton!
    var cigarets = false
    var drugs = false
    var alcohol = false
    var pragnent = false
    var workoutRegular = false
    var haveSick = false
    var sugarRate = 0
    var nashta = false
    var hours2afterlaunch = false
    var pragnentinnashta = false
    var pragnentafterfood = false
    var pragnetwithdiabetinnashta = false
    var pragnetwithdiabetafterfood = false
    var haveDangrous = false
    var statusUser : patientStatus = .normal
    
    

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        let toolbar = UIToolbar();
        toolbar.sizeToFit();
        let donebutton = UIBarButtonItem(title: "بستن", style: UIBarButtonItemStyle.done, target: self, action: #selector(self.doneclick));
        
        toolbar.setItems([donebutton], animated: false);
        sugarAmount.layer.borderColor = UIColor.white.cgColor
        sugarAmount.layer.borderWidth = 1
        sugarAmount.layer.cornerRadius = 10
        sugarAmount.inputAccessoryView = toolbar
        timeTest.layer.cornerRadius = 10
        checkboxcontainer.layer.cornerRadius = 10
        sickInPast.layer.cornerRadius = 10
    
    }
    @objc func doneclick() {
        self.view.endEditing(true)
    }


    @IBAction func closeViewConroller(_ sender: UIButton) {
        dismiss(animated: true)
    }
    @IBAction func checkboxTapped(_ sender: UIButton) {
        if sender.image(for: .normal) == #imageLiteral(resourceName: "unchecked-checkbox"){
            sender.setImage(#imageLiteral(resourceName: "checked-checkbox"), for: .normal)
            switch sender.tag {
            case 0:
                cigarets = true
            case 1:
                drugs = true
            case 2:
                alcohol = true
            case 3:
                pragnent = true
            case 4:
                workoutRegular = true
            default:
                print("it is out of range")
            }
        }else{
            sender.setImage(#imageLiteral(resourceName: "unchecked-checkbox"), for: .normal)
            switch sender.tag {
            case 0:
                cigarets = false
            case 1:
                drugs = false
            case 2:
                alcohol = false
            case 3:
                pragnent = false
            case 4:
                workoutRegular = false
            default:
                print("it is out of range")
            }
        }
        
        switch sender.tag {
        case 0:
            cigarets = true
        case 1:
            drugs = true
        case 2:
            alcohol = true
        case 3:
            pragnent = true
        case 4:
            workoutRegular = true
        default:
            print("it is out of range")
        }
    }
    
    @IBAction func hadSick(_ sender: UIButton) {
        McPicker.show(data: [["دارم","ندارم"]]) { (selections: [Int : String]) -> Void in
            if let title = selections[0] {
                if title == "دارم"{
                    self.haveSick = true
                }else{
                    self.haveSick = false
                }
                self.sickInPast.setTitle( " سابقه دیابت \(title)" , for: .normal)
                
            }
        }
    }
    @IBAction func selectInterval(_ sender: UIButton) {
        McPicker.show(data: [["ناشتا", " دو ساعت بعد ازغذا", "باردار در ناشتا", "باردار بعد از غذا","باردار با سابقه دیابت در ناشتا", "باردار با سابقه دیابت بعد از غذا"]]) { (selections: [Int : String]) -> Void in
            if let title = selections[0] {
                
                self.timeTest.setTitle( title , for: .normal)
                switch title{
                case "ناشتا":
                    self.nashta = true
                case "دو ساعت بعد ازغذا":
                    self.hours2afterlaunch = true
                case "باردار در ناشتا":
                    self.pragnentinnashta = true
                case "باردار بعد از غذا":
                    self.pragnentafterfood = true
                case "باردار با سابقه دیابت در ناشتا":
                    self.pragnetwithdiabetinnashta = true
                case  "باردار با سابقه دیابت بعد از غذا":
                    self.pragnetwithdiabetafterfood = true
                default:
                    print("it is out of range")
                    
                }

            }
        }
    }
    
    @IBAction func savecheckup(_ sender: UIButton) {
        
        if sugarAmount.text != "" && haveSick != false && timeTest.titleLabel?.text != "زمان انجام آزمایش"{
            haveDangrous = isDangrous()
            if ((cigarets == true || drugs == true || pragnent == true || workoutRegular == true) && haveSick == true){
                statusUser = .danger
                simpleAlert("danger")
            }else{
                if haveSick == true{
                    statusUser = .alarm
                    simpleAlert("alarm")
                }else{
                    statusUser = .normal
                    simpleAlert("normal")
                }
            }
        }else{
            simpleAlert("میزان قند خون ، زمان تست و سابقه بیماری الزامی می باشند")
        }

        
        
        
    }
    
    
    
    
    
    
    func isDangrous() -> Bool{
        let bloodSugarNumber = Int(sugarAmount.text!)
        if nashta == true{
            if haveSick == true{
                if (bloodSugarNumber! > 80 && bloodSugarNumber! < 130) {
                    return false;
                } else {
                    return true;
                }
                
            }else{
                
                if (bloodSugarNumber! > 70 && bloodSugarNumber! < 99) {
                    return false;
                } else {
                    return true;
                }
            }
        }else if hours2afterlaunch == true{
            if haveSick == true{
                if (bloodSugarNumber! > 100 && bloodSugarNumber! < 180) {
                    return false;
                } else {
                    return true;
                }
            }else{
                
                if (bloodSugarNumber! > 80 && bloodSugarNumber! < 140) {
                    return false;
                } else {
                    return true;
                }
                
            }
        }else if pragnentinnashta == true{
            if (bloodSugarNumber! > 65 && bloodSugarNumber! < 95) {
                return false;
            } else {
                return true;
            }
        }else if pragnentafterfood == true{
            if (bloodSugarNumber! > 65 && bloodSugarNumber! < 130) {
                return false;
            } else {
                return true;
            }
        }else if pragnetwithdiabetinnashta == true{
            if (bloodSugarNumber! > 60 && bloodSugarNumber! < 99) {
                return false;
            } else {
                return true;
            }
        }else if pragnetwithdiabetafterfood == true{
            if (bloodSugarNumber! > 100 && bloodSugarNumber! < 129) {
                return false;
            } else {
                return true;
            }
        }

        return true
    }
    
    
}
