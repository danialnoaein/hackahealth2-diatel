//
//  Addreminder.swift
//  Diatel
//
//  Created by M.A.R.G on 2/7/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit
import DLLocalNotifications
import McPicker
import CoreData
class Addreminder: UIViewController {

    //MARK: Outlet and Variables
    /**********************************************************/
    @IBOutlet weak var backgroundPattern: UIImageView!
    @IBOutlet weak var startdate: UIButton!
    @IBOutlet weak var patientName: UITextField!
    @IBOutlet weak var notificationName: UITextField!
    @IBOutlet weak var notificationDescription: UITextField!
    @IBOutlet weak var starttimeButton: UIButton!
    @IBOutlet weak var intervalButton: UIButton!
    @IBOutlet weak var daysInterval: UIButton!
    @IBOutlet weak var savebutton: UIBarButtonItem!
    @IBOutlet weak var closebutton: UIBarButtonItem!
    var currentdate : Date?
    var selectedstartdate : String?
    var timeInterval : Int?
    var dayInterval : Int?
    let customFont = UIFont(name: "Shabnam", size: 17.0);
    
    let managedContext = (UIApplication.shared.delegate as! AppDelegate).persistentContainer.viewContext
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
        daysInterval.layer.cornerRadius = daysInterval.frame.height / 2
        intervalButton.layer.cornerRadius = intervalButton.frame.height / 2
        starttimeButton.layer.cornerRadius = starttimeButton.frame.height / 2
        patientName.layer.cornerRadius = patientName.frame.height / 2
        notificationName.layer.cornerRadius = patientName.frame.height / 2
        notificationDescription.layer.cornerRadius = patientName.frame.height / 2
        backgroundPattern.clipsToBounds = true
        self.navigationItem.title = "افزودن یادآور"
        
        
        let toolbar = UIToolbar();
        toolbar.sizeToFit();
        let donebutton = UIBarButtonItem(title: "بستن", style: UIBarButtonItemStyle.done, target: self, action: #selector(self.doneclick));
        
        toolbar.setItems([donebutton], animated: false);
        
        notificationName.inputAccessoryView = toolbar
        notificationDescription.inputAccessoryView = toolbar
        patientName.inputAccessoryView = toolbar
        
        
        
    }
    
    @objc func doneclick() {
        self.view.endEditing(true)
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        view.endEditing(true)
    }
    //MARK: Actions
    /**********************************************************/
    @IBAction func closeViewController(_ sender: Any) {
        backgroundPattern.alpha = 0
        dismiss(animated: true)
    }
    
    
    @IBAction func saveReminder(_ sender: UIBarButtonItem) {
        // let triggerDate = Date().addingTimeInterval(30)
        let idofnotification = randomString(length: 5)
        
        
        
        if(notificationName.text != nil && notificationDescription.text != nil && dayInterval != nil && timeInterval != nil && patientName.text != nil){
            
            let firstNotification = DLNotification(identifier: "", alertTitle: notificationName.text!, alertBody: notificationDescription.text!, date: currentdate!, repeats: .None, subTitle: patientName.text!)
            
            let scheduler = DLNotificationScheduler()
            
            scheduler.repeatsFromToDate(identifier: idofnotification, alertTitle: notificationName.text!, alertBody: notificationDescription.text!, fromDate: currentdate!, toDate: currentdate!.addingTimeInterval(TimeInterval(3600 * 24 * dayInterval!)) , interval: Double(timeInterval! * 3600), repeats: .None, subtitle: patientName.text! )
            scheduler.scheduleNotification(notification: firstNotification);
            //MARK: save in Coredata
            /**********************************************************/
            let notificationdetail = NSEntityDescription.insertNewObject(forEntityName: "NotificationEntity", into: managedContext) as! NotificationEntity
            notificationdetail.id = idofnotification
            notificationdetail.time = currentdate! as NSDate
            notificationdetail.name = notificationName.text!
            notificationdetail.patientname = patientName.text!
            notificationdetail.descript = notificationDescription.text!
            
            
            do {
                try managedContext.save()
            } catch {
                fatalError("Failure to save context: \(error)")
            }
            backgroundPattern.alpha = 0
            dismiss(animated: true)
            
        }else{
            self.savebutton.setTitleTextAttributes([NSAttributedStringKey.font: self.customFont!], for: .normal);
            self.closebutton.setTitleTextAttributes([NSAttributedStringKey.font: self.customFont!], for: .normal);
            simpleAlert("تمامی فیلدها الزامی می باشند ،لطفا اطلاعات را کامل وارد کنید")
            
        }
        
        
        
    }
    
    @IBAction func selectdate(_ sender: UIButton) {
        var pickerdate = UIDatePicker()
        var height = NSLayoutConstraint()
        let margin:CGFloat = 5.0
        let showalertdate = UIAlertController(title: "انتخاب تاریخ", message: "", preferredStyle: .actionSheet);
        if let popoverController = showalertdate.popoverPresentationController {
            popoverController.sourceView = self.view
            popoverController.sourceRect = sender.frame
            pickerdate.frame =  CGRect(x: 0, y: 0, width: 300, height: 400);
            height = NSLayoutConstraint(item: showalertdate.view, attribute: NSLayoutAttribute.height, relatedBy: NSLayoutRelation.equal, toItem: nil, attribute: NSLayoutAttribute.notAnAttribute, multiplier: 1, constant: 450);
        }else{
            pickerdate.frame =  CGRect(x: 0, y: 0, width: showalertdate.view.bounds.size.width - margin * 4.0, height: showalertdate.view.bounds.height - 100);
            height = NSLayoutConstraint(item: showalertdate.view, attribute: NSLayoutAttribute.height, relatedBy: NSLayoutRelation.equal, toItem: nil, attribute: NSLayoutAttribute.notAnAttribute, multiplier: 1, constant: self.view.frame.height);
        }

        
        
        showalertdate.view.addConstraint(height);
        pickerdate.calendar = NSCalendar(identifier: NSCalendar.Identifier.persian)! as Calendar;
        pickerdate.locale = NSLocale(localeIdentifier: "fa_IR") as Locale;
        pickerdate.datePickerMode = .dateAndTime;
        pickerdate.minimumDate = Date();
        pickerdate.isUserInteractionEnabled = true;
        //pickerdate.changeFont(textfont: UIFont(name: "Shabnam-Bold", size: 16)!)
        if let setcurentdat = currentdate {
            pickerdate.setDate(setcurentdat, animated: false);
        }
        
        
        showalertdate.addAction(UIAlertAction(title: "تایید", style: .cancel, handler: { (UIAlertAction) in
            
            
            let formatter = DateFormatter()
            // initially set the format based on your datepicker date
            formatter.locale = NSLocale(localeIdentifier: "fa_IR") as Locale!
            formatter.dateFormat = "dd/MMM/yyyy, H:mm";
            formatter.calendar = NSCalendar(identifier: NSCalendar.Identifier.persian)! as Calendar;
            formatter.locale = NSLocale(localeIdentifier: "fa_IR") as Locale;
            self.currentdate = pickerdate.date;
            
            self.selectedstartdate = formatter.string(from: self.currentdate!)
            
            self.startdate.setTitle(self.selectedstartdate, for: .normal);
        }));
        
    
        
        showalertdate.view.addSubview(pickerdate);
        self.present(showalertdate, animated: true, completion: {() in
            print("changed font")
            self.savebutton.setTitleTextAttributes([NSAttributedStringKey.font: self.customFont!], for: .normal);
            self.closebutton.setTitleTextAttributes([NSAttributedStringKey.font: self.customFont!], for: .normal);
        });
    }
    
    
    @IBAction func timeinterval(_ sender: UIButton) {
        
        McPicker.show(data: [["1", "2", "3", "4","5", "6", "7", "8","9", "10", "11", "12","13", "14", "15", "16","17", "18", "19", "20","21", "22", "23", "24"]]) { (selections: [Int : String]) -> Void in
            if let name = selections[0] {
                self.timeInterval = Int(name)
                self.intervalButton.setTitle("هر \(name) ساعت", for: .normal)
                
            }
        }
    }
    
    
    @IBAction func DaysInterval(_ sender: UIButton) {
        McPicker.show(data: [["1", "2", "3", "4","5", "6", "7", "8","9", "10"]]) { (selections: [Int : String]) -> Void in
            if let name = selections[0] {
                self.dayInterval = Int(name)
                self.daysInterval.setTitle("\(name) روز", for: .normal)
                
            }
        }
    }
    //MARK: Table Delegate Methods
    /**********************************************************/
    
    func randomString(length: Int) -> String {
        
        let letters : NSString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        let len = UInt32(letters.length)
        
        var randomString = ""
        
        for _ in 0 ..< length {
            let rand = arc4random_uniform(len)
            var nextChar = letters.character(at: Int(rand))
            randomString += NSString(characters: &nextChar, length: 1) as String
        }
        
        return randomString
    }
    
}
