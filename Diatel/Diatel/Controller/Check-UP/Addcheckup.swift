//
//  Addcheckup.swift
//  Diatel
//
//  Created by M.A.R.G on 2/7/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit
import McPicker
class Addcheckup: UIViewController {

    @IBOutlet weak var sugarAmount: UITextField!
    @IBOutlet weak var timeTest: UIButton!
    @IBOutlet weak var checkboxcontainer: UIView!
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
        }else{
            sender.setImage(#imageLiteral(resourceName: "unchecked-checkbox"), for: .normal)
        }
    }
    
    @IBAction func selectInterval(_ sender: UIButton) {
        McPicker.show(data: [["ناشتا", " دو ساعت بعد ازغذا", "باردار در ناشتا", "باردار بعد از غذا","باردار با سابقه دیابت در ناشتا", "باردار با سابقه دیابت بعد از غذا"]]) { (selections: [Int : String]) -> Void in
            if let title = selections[0] {
                
                self.timeTest.setTitle( title , for: .normal)
                
            }
        }
    }
}
