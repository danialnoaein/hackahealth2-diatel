//
//  RegimeCellTableViewCell.swift
//  Diatel
//
//  Created by M.A.R.G on 2/8/1398 AP.
//  Copyright © 1398 MohamedRezaGhate. All rights reserved.
//

import UIKit

class RegimeCellTableViewCell: UITableViewCell {

    @IBOutlet weak var container: UIView!
    @IBOutlet weak var titleText: UILabel!
    @IBOutlet weak var dayName: UILabel!
    @IBOutlet weak var meals: UITextView!
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
        container.layer.cornerRadius = 10
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
