//
//  DetailTraning.swift
//  Diatel
//
//  Created by M.A.R.G on 2/7/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class DetailTraning: UIViewController,UITableViewDelegate,UITableViewDataSource {


    @IBOutlet weak var tableview: UITableView!
    override func viewDidLoad() {
        super.viewDidLoad()
        tableview.delegate = self
        tableview.dataSource = self

        // Do any additional setup after loading the view.
        let color1 = UIColor(red: 0.2352941176, green: 0.6823529412, blue: 0.6392156863, alpha: 1)
        let color2 = UIColor(red: 0.1254901961, green: 0.3882352941, blue: 0.6078431373, alpha: 1)
        view.setGradientBackground(colorTop: color1, colorBottom: color2)
        tableview.register(UINib.init(nibName: "TrainingTablecell", bundle: nil), forCellReuseIdentifier: "traningtablecell")
        
    }


    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return 10
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableview.dequeueReusableCell(withIdentifier: "traningtablecell", for: indexPath) as! TrainingTablecell;
        
        cell.titleText.text = "موضوع اپلیکیشن دیابت است"
        cell.backgroundColor = UIColor.clear
        cell.datetext.text = "۱۳۹۸"
        cell.imagePlaceholder.image = #imageLiteral(resourceName: "Main-color")
        
        
        return cell
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 150
    }
    

}
