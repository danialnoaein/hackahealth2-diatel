//
//  Reminder.swift
//  Diatel
//
//  Created by M.A.R.G on 2/7/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit
import CoreData
import UserNotifications

class Reminder: UIViewController,UITableViewDelegate,UITableViewDataSource,UNUserNotificationCenterDelegate {
    //MARK: outlets and variables
    /**********************************************************/
    @IBOutlet weak var tableview: UITableView!
    @IBOutlet weak var placeholdertext: UILabel!
    let center = UNUserNotificationCenter.current()
    var numberofsection = 0
    var requestNotifications = [UNNotificationRequest]()
    var tableData :[[Any]]?
    let managedContext = (UIApplication.shared.delegate as! AppDelegate).persistentContainer.viewContext
    var notificationArray: [NotificationEntity] = []
    let fetchrequest = NSFetchRequest<NSFetchRequestResult>(entityName: "NotificationEntity");
    
    override func viewDidLoad() {
        super.viewDidLoad();
        tableview.delegate = self
        tableview.dataSource = self
        let nibfile = UINib(nibName: "ReminderCell", bundle: nil);
        tableview.register(nibfile, forCellReuseIdentifier: "remindercell")
       //UIApplication.shared.cancelAllLocalNotifications()

        // Do any additional setup after loading the view.
        let color1 = UIColor(red: 0.2352941176, green: 0.6823529412, blue: 0.6392156863, alpha: 1)
        let color2 = UIColor(red: 0.1254901961, green: 0.3882352941, blue: 0.6078431373, alpha: 1)
        view.setGradientBackground(colorTop: color1, colorBottom: color2)
        
        
        let addReminder = UIBarButtonItem(barButtonSystemItem: .add, target: self, action: #selector(pushAddReminder));
        self.navigationItem.rightBarButtonItem = addReminder;
        
        
        isNotificationLimitreached { (count) in
            
            print("viewdidload\(count)")
            
        }
        
        fetchFromCoredataEntity()

        
    }
    
    //MARK: Fetch from Coredata
    /**********************************************************/
    func fetchFromCoredataEntity(){
        
        do {
            notificationArray = try managedContext.fetch(fetchrequest) as! [NotificationEntity]
            DispatchQueue.main.async {
                self.tableview.reloadData()
            }
            
            if notificationArray.count == 0{
                placeholdertext.alpha = 1
                tableview.alpha = 0
            }else{
                placeholdertext.alpha = 0
                tableview.alpha = 1
            }
            
            for notification in notificationArray{
                print(notification.id!)
            }
            
        } catch {
            print("Fetching Failed")
        }
    }
    
    @objc func pushAddReminder(){
        let vc = storyboard?.instantiateViewController(withIdentifier: "addreminder") as! Addreminder;
        present(vc, animated: true)
    }
    
    //MARK: viewDidAppear
    /**********************************************************/
    override func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated);
        fetchFromCoredataEntity()
        
    }
    
    
    func changeBackground() {
        //iPads etc
        if traitCollection.horizontalSizeClass == .regular{
            let color1 = UIColor(red: 0.2352941176, green: 0.6823529412, blue: 0.6392156863, alpha: 1)
            let color2 = UIColor(red: 0.1254901961, green: 0.3882352941, blue: 0.6078431373, alpha: 1)
            view.setGradientBackground(colorTop: color1, colorBottom: color2)
            
        }
        else if traitCollection.verticalSizeClass == .compact{
            let color1 = UIColor(red: 0.2352941176, green: 0.6823529412, blue: 0.6392156863, alpha: 1)
            let color2 = UIColor(red: 0.1254901961, green: 0.3882352941, blue: 0.6078431373, alpha: 1)
            view.setGradientBackground(colorTop: color1, colorBottom: color2)
            
        }
    }
    
    
    
    override func traitCollectionDidChange(_ previousTraitCollection: UITraitCollection?) {
        super.traitCollectionDidChange(previousTraitCollection)
        changeBackground()
    }
    
    
    //MARK: Notification Delegate Methods
    /**********************************************************/
    func userNotificationCenter(_ center: UNUserNotificationCenter, willPresent notification: UNNotification, withCompletionHandler completionHandler: @escaping (UNNotificationPresentationOptions) -> Void) {
        
        DispatchQueue.main.async {
            self.isNotificationLimitreached { (count) in
                self.numberofsection = count
                self.tableview.reloadData()
            }
        }
        
        
    }
    
    
    //MARK: Table Delegate Methods
    /**********************************************************/
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // return numberofsection
        return notificationArray.count
    }
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "remindercell", for: indexPath) as! ReminderCell
        
        cell.backgroundColor = UIColor.clear
        cell.title.text = notificationArray[indexPath.item].name
        cell.patientName.text = notificationArray[indexPath.item].patientname
        cell.id.text = notificationArray[indexPath.item].id
        let trigger = notificationArray[indexPath.item].time! as Date
        
        let dateFormatter = DateFormatter()
        dateFormatter.dateFormat = "HH:mm:ss"//"EE" to get short style
        let mydt = dateFormatter.string(from: trigger).capitalized
        cell.time.text = "\(mydt)"

        return cell
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        tableview.deselectRow(at: indexPath, animated: true)
    }
    
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 140
    }
    
    
    func tableView(_ tableView: UITableView, canEditRowAt indexPath: IndexPath) -> Bool {
        return true
    }
    
    func tableView(_ tableView: UITableView, editActionsForRowAt indexPath: IndexPath) -> [UITableViewRowAction]? {
        let actionDelete = UITableViewRowAction(style: .destructive, title: "حذف") { (deleteAction, indexpath) in
 
            let object = self.notificationArray.remove(at: indexPath.row)
            self.center.getPendingNotificationRequests(completionHandler: { requests in
                for request in requests{
                    if request.identifier.range(of:object.id!) != nil {
                        self.center.removePendingNotificationRequests(withIdentifiers: [request.identifier])
                    }
                }
                
            });
            
            self.managedContext.delete(object);

            self.tableview.beginUpdates();
            tableView.deleteRows(at: [indexpath], with: .fade)
            self.tableview.endUpdates()
            
            if self.notificationArray.count == 0{
                self.placeholdertext.alpha = 1
                self.tableview.alpha = 0
            }else{
                self.placeholdertext.alpha = 0
                self.tableview.alpha = 1
            }
            
            
            do {
                try self.managedContext.save()
            } catch {
                fatalError("Failure to save context: \(error)")
            }
            
        }
        
        
        return [actionDelete]
    }

    
    //MARK: UNUserNotificationCenter Count Requests
    /**********************************************************/
    func isNotificationLimitreached(completed: @escaping (Int)-> Void = {_ in }) {
        
        center.getPendingNotificationRequests(completionHandler: { requests in
            print(requests)
            for request in requests{
                let str = request.identifier
                
                let decimalCharacters = CharacterSet.decimalDigits
                
                let decimalRange = str.rangeOfCharacter(from: decimalCharacters)
                
                if decimalRange == nil {
                    self.requestNotifications.append(request)
                }
            }
            completed(self.requestNotifications.count)
        });
    }


}
