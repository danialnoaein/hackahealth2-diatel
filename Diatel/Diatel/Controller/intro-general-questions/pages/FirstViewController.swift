//
//  FirstViewController.swift
//  Diatel
//
//  Created by M.A.R.G on 2/8/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class FirstViewController: UIViewController {
    
    //MARK: variables and outlets
    /**********************************************************/
    @IBOutlet weak var name: UITextField!
    @IBOutlet weak var age: UITextField!
    @IBOutlet weak var femaleBtn: UIButton!
    @IBOutlet weak var maleBtn: UIButton!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let color1 = UIColor(red: 0.2352941176, green: 0.6823529412, blue: 0.6392156863, alpha: 1)
        let color2 = UIColor(red: 0.1254901961, green: 0.3882352941, blue: 0.6078431373, alpha: 1)
        view.setGradientBackground(colorTop: color1, colorBottom: color2)
        

        // Do any additional setup after loading the view.
        let toolbar = UIToolbar();
        toolbar.sizeToFit();
        let donebutton = UIBarButtonItem(title: "بستن", style: UIBarButtonItemStyle.done, target: self, action: #selector(self.doneclick));
        
        toolbar.setItems([donebutton], animated: false);
        
        name.inputAccessoryView = toolbar;
        age.inputAccessoryView = toolbar;
        name.layer.borderColor = UIColor.white.cgColor
        age.layer.borderColor = UIColor.white.cgColor
        name.layer.borderWidth = 1
        age.layer.borderWidth = 1
        name.layer.cornerRadius = 10
        age.layer.cornerRadius = 10
        maleBtn.layer.cornerRadius = 10
        femaleBtn.layer.cornerRadius = 10
    }
    
    @objc func doneclick() {
        self.view.endEditing(true)
    }

    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }
    //MARK: Actions
    /**********************************************************/

    @IBAction func FemaleSelected(_ sender: UIButton) {
        sender.clipsToBounds = true
        sender.layer.borderWidth = 1;
        sender.layer.borderColor = UIColor.white.cgColor
        maleBtn.layer.borderWidth = 0;
    }
    
    @IBAction func Maleselected(_ sender: UIButton) {
        sender.clipsToBounds = true
        sender.layer.borderWidth = 1;
        sender.layer.borderColor = UIColor.white.cgColor
        femaleBtn.layer.borderWidth = 0;
    }
    
    @IBAction func gotonextpage(_ sender: UIButton) {
        let pageController = self.parent as! UIPageViewController
        
        pageController.goToNextPage()
    }
}
