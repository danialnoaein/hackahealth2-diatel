//
//  SecondViewController.swift
//  Diatel
//
//  Created by M.A.R.G on 2/8/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class SecondViewController: UIViewController {
    //MARK: variables and outlets
    /**********************************************************/
    @IBOutlet weak var height: UITextField!
    @IBOutlet weak var weight: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        let color1 = UIColor(red: 0.2352941176, green: 0.6823529412, blue: 0.6392156863, alpha: 1)
        let color2 = UIColor(red: 0.1254901961, green: 0.3882352941, blue: 0.6078431373, alpha: 1)
        view.setGradientBackground(colorTop: color2, colorBottom: color1)
        
        // Do any additional setup after loading the view.
        let toolbar = UIToolbar();
        toolbar.sizeToFit();
        let donebutton = UIBarButtonItem(title: "بستن", style: UIBarButtonItemStyle.done, target: self, action: #selector(self.doneclick));
        
        toolbar.setItems([donebutton], animated: false);
        
        height.inputAccessoryView = toolbar;
        weight.inputAccessoryView = toolbar;
        height.layer.borderColor = UIColor.white.cgColor
        weight.layer.borderColor = UIColor.white.cgColor
        height.layer.borderWidth = 1
        weight.layer.borderWidth = 1
        height.layer.cornerRadius = 10
        weight.layer.cornerRadius = 10
    }
    
    
    
    //MARK: Actions
    /**********************************************************/
    @objc func doneclick() {
        self.view.endEditing(true)
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?) {
        self.view.endEditing(true)
    }

    @IBAction func nexttopage(_ sender: UIButton) {
        let pageController = self.parent as! UIPageViewController
        
        pageController.goToNextPage()
    }
    
}
